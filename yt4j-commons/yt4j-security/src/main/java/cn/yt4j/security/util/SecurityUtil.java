/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.security.util;

import cn.yt4j.security.model.Yt4jUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author gyv12345@163.com
 */
@UtilityClass
public class SecurityUtil {

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public Yt4jUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof Yt4jUser) {
			return (Yt4jUser) principal;
		}
		return null;
	}

	public Yt4jUser getUser() {
		Authentication authentication = getAuthentication();
		return getUser(authentication);
	}

}
