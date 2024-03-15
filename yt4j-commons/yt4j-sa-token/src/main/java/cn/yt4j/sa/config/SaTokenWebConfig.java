
package cn.yt4j.sa.config;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.same.SaSameUtil;
import cn.yt4j.core.domain.Result;
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
		return new SaServletFilter().addInclude("/**")
			.setExcludeList(saIgnoredUrlProperty.getIgnoredUrl())
			.setAuth(obj -> SaSameUtil.checkCurrentRequestToken())
			.setError(e -> Result.failed(e.getMessage()));
	}

}
