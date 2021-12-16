/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.exception.Yt4jException;
import cn.yt4j.security.model.UserCache;
import cn.yt4j.security.util.JwtUtil;
import cn.yt4j.security.util.SecurityUtil;
import cn.yt4j.sys.dao.SysMenuDao;
import cn.yt4j.sys.dao.SysRoleDao;
import cn.yt4j.sys.dao.SysUserDao;
import cn.yt4j.sys.dao.SysUserRoleDao;
import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.SysUserRole;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.entity.vo.ActionEntitySet;
import cn.yt4j.sys.entity.vo.Permissions;
import cn.yt4j.sys.entity.vo.Role;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static cn.yt4j.core.enums.MessageStatus.PASSWORD_FAILED;

/**
 * 用户(SysUser)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@RequiredArgsConstructor
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

	private final PasswordEncoder encoder;

	private final JwtUtil jwtUtil;

	private final RedisTemplate<String, UserCache> redisTemplate;

	private final SysUserRoleDao sysUserRoleDao;

	private final SysRoleDao sysRoleDao;

	private final SysMenuDao sysMenuDao;

	@Override
	public String login(UserDTO dto) {
		SysUser user = this.baseMapper
				.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, dto.getUsername()));
		if (ObjectUtil.isNull(user)) {
			throw new BadCredentialsException("用户名或密码错误");
		}
		else {
			// 通过密码编码器比较密码
			if (encoder.matches(dto.getPassword(), user.getPassword())) {
				// 登录成功，创建token，我们需要在这里返回userDetail内容，包含权限信息,并将其放入redis，通过redis跨项目共享
				String token = jwtUtil.generateToken(user.getUsername());

				UserCache cache = new UserCache();
				cache.setId(user.getId());
				BeanUtils.copyProperties(user, cache);
				cache.setRoles(sysRoleDao.listByUserId(user.getId()));
				cache.setMenus(sysMenuDao.listByUserId(user.getId()));

				redisTemplate.opsForValue().set(SecurityConstants.SECURITY_PREFIX + user.getUsername(), cache, 30L,
						TimeUnit.DAYS);

				return token;
			}
			else {
				throw new BadCredentialsException("用户名或密码错误");
			}
		}
	}

	@Override
	public void logout() {
		redisTemplate.opsForValue().getOperations().delete(SecurityUtil.getUser().getUsername());
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean updatePassword(PasswordDTO dto) {
		SysUser user = this.baseMapper.selectById(SecurityUtil.getUser().getId());
		if (encoder.matches(dto.getOldPwd(), user.getPassword())) {
			user.setPassword(encoder.encode(dto.getNewPwd()));
			this.baseMapper.updateById(user);
			return Boolean.TRUE;
		}
		throw new Yt4jException(PASSWORD_FAILED);
	}

	@Override
	public UserInfo getInfo(Long id) {
		// 创建最终返回对象
		UserInfo userInfo = new UserInfo();
		Role role = new Role();
		List<Permissions> permissionsList = new ArrayList<>();

		// 查询用户，查询用户的菜单，获取菜单下按钮权限
		SysUser user = this.getById(id);
		List<SysMenu> menus = this.sysMenuDao.listMenuByUserId(id);
		menus.forEach(sysMenu -> {
			Permissions permissions = new Permissions();
			permissions.setPermissionId(sysMenu.getPermission());
			permissions.setPermissionName(sysMenu.getPermission());
			permissions.setActionEntitySet(this.sysMenuDao
					.selectList(Wrappers.<SysMenu>lambdaQuery().eq(SysMenu::getParentId, sysMenu.getId())).stream()
					.map(menu -> {
						ActionEntitySet set = new ActionEntitySet();
						set.setAction(menu.getPermission());
						set.setDescribe(menu.getTitle());
						set.setDefaultCheck(false);
						return set;
					}).collect(Collectors.toList()));
			permissionsList.add(permissions);
		});

		// 拼装
		userInfo.setName(user.getNickName());
		userInfo.setAvatar(user.getAvatar());
		role.setPermissions(permissionsList);
		userInfo.setRole(role);
		return userInfo;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean insert(SysUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setState(true);
		this.save(user);
		if (ObjectUtil.isNotNull(user.getRoleIds())) {
			this.sysUserRoleDao.batchAdd(user.getId(), user.getRoleIds());
		}
		return Boolean.TRUE;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean update(SysUser user) {
		this.sysUserRoleDao.delete(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, user.getId()));
		if (ObjectUtil.isNotNull(user.getRoleIds())) {
			this.sysUserRoleDao.batchAdd(user.getId(), user.getRoleIds());
		}
		this.updateById(user);
		return Boolean.TRUE;
	}

	@Override
	public SysUser one(Long id) {
		SysUser user = this.getById(id);
		user.setRoleIds(
				this.sysUserRoleDao.selectList(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, id))
						.stream().map(SysUserRole::getRoleId).collect(Collectors.toList()));
		return user;
	}

	@Override
	public Boolean resetPassword(Long id) {
		SysUser user = new SysUser();
		user.setId(id);
		user.setPassword(encoder.encode("123456"));
		this.updateById(user);
		return Boolean.TRUE;
	}

}
