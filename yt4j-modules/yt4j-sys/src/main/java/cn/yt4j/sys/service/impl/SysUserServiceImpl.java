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

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.domain.SaUserCache;
import cn.yt4j.core.enums.MessageStatus;
import cn.yt4j.core.exception.Yt4jException;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.dao.SysMenuDao;
import cn.yt4j.sys.dao.SysRoleDao;
import cn.yt4j.sys.dao.SysUserDao;
import cn.yt4j.sys.dao.SysUserRoleDao;
import cn.yt4j.sys.api.entity.SysMenu;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.entity.SysUserRole;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.vo.ActionEntitySet;
import cn.yt4j.sys.entity.vo.Permissions;
import cn.yt4j.sys.entity.vo.Role;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

	private final SysUserRoleDao sysUserRoleDao;

	private final SysRoleDao sysRoleDao;

	private final SysMenuDao sysMenuDao;

	@Override
	public String login(LoginDTO dto) {
		SysUser user = this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, dto.getUsername()));
		if (ObjectUtil.isNull(user)) {
			throw new Yt4jException(MessageStatus.LOGIN_FAILED);
		}
		else {
			// 密码比较，一直
			if (ObjectUtil.equals(SaSecureUtil.md5(dto.getPassword()), user.getPassword())) {
				StpUtil.login(user.getId());
				String token = StpUtil.getTokenValue();
				SaSession session = StpUtil.getTokenSession();
				SaUserCache userCache = new SaUserCache();
				userCache.setId(user.getId());
				userCache.setUsername(user.getUsername());
				userCache.setRealName(user.getNickName());
				userCache.setRoles(this.sysRoleDao.listByUserId(user.getId()));
				userCache.setPermissions(this.sysMenuDao.listByUserId(user.getId()));
				session.set(SecurityConstants.SECURITY_PREFIX, userCache);
				return token;
			}
			else {
				throw new Yt4jException(MessageStatus.LOGIN_FAILED);
			}
		}
	}

	@Override
	public void logout() {
		StpUtil.logout();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean updatePassword(PasswordDTO dto) {
		SysUser user = this.baseMapper.selectById(StpUtil.getLoginIdAsLong());
		if (ObjectUtil.equals(SaSecureUtil.md5(dto.getOldPwd()), user.getPassword())) {
			user.setPassword(SaSecureUtil.md5(dto.getNewPwd()));
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
		user.setPassword(SaSecureUtil.md5(user.getPassword()));
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
		user.setPassword(SaSecureUtil.md5("123456"));
		this.updateById(user);
		return Boolean.TRUE;
	}

}
