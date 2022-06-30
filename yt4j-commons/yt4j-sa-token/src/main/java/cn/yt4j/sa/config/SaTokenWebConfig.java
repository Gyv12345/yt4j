/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sa.config;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.id.SaIdUtil;
import cn.yt4j.core.domain.R;
import cn.yt4j.sa.property.SaIgnoredUrlProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gyv12345@163.com
 */
@RequiredArgsConstructor
@Configuration
public class SaTokenWebConfig implements WebMvcConfigurer {

	private final SaIgnoredUrlProperty saIgnoredUrlProperty;

	@Bean
	public SaServletFilter getSaServletFilter() {
		return new SaServletFilter().addInclude("/**").addExclude("/actuator/**")
				.setAuth(obj -> SaIdUtil.checkCurrentRequestToken()).setError(e -> R.failed(e.getMessage()));
	}

}
