
package cn.yt4j.sa.service;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.domain.SaUserCache;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限验证接口扩展
 *
 * @author gyv12345@163.com
 */
@Component
public class StpInterfaceImpl implements StpInterface {

	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		SaUserCache userCache = getSaUserCache(loginId);
		return userCache.getPermissions();
	}

	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		SaUserCache userCache = getSaUserCache(loginId);
		return userCache.getRoles();
	}

	private SaUserCache getSaUserCache(Object loginId) {
		String token = StpUtil.getTokenValueByLoginId(loginId);
		SaSession session = StpUtil.getTokenSessionByToken(token);
		SaUserCache userCache = session.getModel(SecurityConstants.SECURITY_PREFIX, SaUserCache.class);
		return userCache;
	}

}
