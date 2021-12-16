/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
