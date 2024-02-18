package cn.yt4j.auth.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.auth.service.AuthService;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.domain.SaUserCache;
import cn.yt4j.core.enums.MessageStatus;
import cn.yt4j.core.exception.Yt4jException;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.api.entity.vo.SysUserVO;
import cn.yt4j.sys.api.service.LoginClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 鉴权业务
 *
 * @author gyv12345@163.com
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

	private final LoginClient loginClient;

	@Override
	public String login(LoginDTO dto) {
		log.info("登录");
		SysUserVO user = this.loginClient.getUserByUsername(dto.getUsername()).getData();
		if (ObjectUtil.isNull(user)) {
			throw new Yt4jException(MessageStatus.LOGIN_FAILED);
		}
		else {
			// 密码比较
			// todo 增加次数判断，出错进行锁定
			if (ObjectUtil.equals(SaSecureUtil.md5(dto.getPassword()), user.getPassword())) {
				StpUtil.login(user.getId());
				String token = StpUtil.getTokenValue();
				SaSession session = StpUtil.getTokenSession();
				SaUserCache userCache = new SaUserCache();
				userCache.setId(user.getId());
				userCache.setUsername(user.getUsername());
				userCache.setRealName(user.getNickName());
				userCache.setDeptId(user.getDeptId());
				userCache.setRoles(this.loginClient.listRoleByUserId(user.getId()).getData());
				userCache.setPermissions(this.loginClient.listMenuByUserId(user.getId()).getData());
				session.set(SecurityConstants.SECURITY_PREFIX, userCache);
				return token;
			}
			else {
				throw new Yt4jException(MessageStatus.LOGIN_FAILED);
			}
		}
	}

}
