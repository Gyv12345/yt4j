package cn.yt4j.sa.util;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.core.domain.SaUserCache;
import lombok.experimental.UtilityClass;

/**
 * 帮助
 *
 * @author gyv12345@163.com
 */
@UtilityClass
public class AuthUtil {

	public SaUserCache getUser() {
		SaSession session = StpUtil.getTokenSession();
		SaUserCache userCache = session.getModel(SecurityConstants.SECURITY_PREFIX, SaUserCache.class);
		return userCache;
	}

	public Long getUserId() {
		SaUserCache user = getUser();
		return user.getId();
	}

}
