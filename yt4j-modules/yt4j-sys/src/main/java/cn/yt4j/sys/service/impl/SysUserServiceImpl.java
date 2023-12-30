
package cn.yt4j.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.domain.SaUserCache;
import cn.yt4j.core.enums.MessageStatus;
import cn.yt4j.core.exception.Yt4jException;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.entity.SysUserRole;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.mapper.SysMenuMapper;
import cn.yt4j.sys.mapper.SysRoleMapper;
import cn.yt4j.sys.mapper.SysUserMapper;
import cn.yt4j.sys.mapper.SysUserRoleMapper;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

import static cn.yt4j.core.enums.MessageStatus.PASSWORD_FAILED;

/**
 * 用户(SysUser)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@Slf4j
@RequiredArgsConstructor
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private final SysUserRoleMapper sysUserRoleMapper;

	private final SysRoleMapper sysRoleMapper;

	private final SysMenuMapper sysMenuMapper;

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
				userCache.setRoles(this.sysRoleMapper.listByUserId(user.getId()));
				userCache.setPermissions(this.sysMenuMapper.listByUserId(user.getId()));
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
		// 查询用户，查询用户的菜单，获取菜单下按钮权限
		SysUser user = this.getById(id);
		// 创建最终返回对象
		UserInfo userInfo = new UserInfo();
		// 拼装
		userInfo.setName(user.getNickName());
		userInfo.setAvatar(user.getAvatar());
		userInfo.setRole("*");
		return userInfo;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean insert(SysUser user) {
		user.setPassword(SaSecureUtil.md5(user.getPassword()));
		user.setState(true);
		this.save(user);
		if (ObjectUtil.isNotNull(user.getRoleIds())) {
			this.sysUserRoleMapper.batchAdd(user.getId(), user.getRoleIds());
		}
		return Boolean.TRUE;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean update(SysUser user) {
		this.sysUserRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, user.getId()));
		if (ObjectUtil.isNotNull(user.getRoleIds())) {
			this.sysUserRoleMapper.batchAdd(user.getId(), user.getRoleIds());
		}
		this.updateById(user);
		return Boolean.TRUE;
	}

	@Override
	public SysUser one(Long id) {
		SysUser user = this.getById(id);
		user.setRoleIds(
				this.sysUserRoleMapper.selectList(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, id))
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
