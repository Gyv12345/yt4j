package cn.yt4j.security.config;

import cn.yt4j.security.filter.JwtAuthenticationTokenFilter;
import cn.yt4j.security.handler.RestAuthenticationEntryPoint;
import cn.yt4j.security.handler.RestfulAccessDeniedHandler;
import cn.yt4j.security.property.JwtAuthFilterProperty;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author gyv12345@163.com
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Yt4jSecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	private final UserDetailsService userDetailsService;

	private final PasswordEncoder encoder;

	private final JwtAuthFilterProperty jwtAuthFilterProperty;

	private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

	private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@SneakyThrows
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	/**
	 * HTTP请求安全处理 token请求授权
	 * @param http .
	 * @throws Exception .
	 */
	@SneakyThrows
	@Override
	protected void configure(HttpSecurity http) {

		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
				.authorizeRequests();
		// 不需要保护的资源路径允许访问
		for (String url : jwtAuthFilterProperty.getIgnoredUrl()) {
			registry.antMatchers(url).permitAll();
		}
		// 允许跨域请求的OPTIONS请求
		registry.antMatchers(HttpMethod.OPTIONS).permitAll();
		// 任何请求需要身份认证
		registry.and().authorizeRequests().anyRequest().authenticated()
				// 关闭跨站请求防护及不使用session
				.and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				// 自定义权限拒绝处理类
				.and().exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler)
				.authenticationEntryPoint(restAuthenticationEntryPoint)
				// 自定义权限拦截器JWT过滤器
				.and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
