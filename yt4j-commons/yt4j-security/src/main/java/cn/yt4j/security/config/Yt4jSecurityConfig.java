/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.security.config;

import cn.yt4j.security.filter.JwtAuthenticationTokenFilter;
import cn.yt4j.security.handler.RestAuthenticationEntryPoint;
import cn.yt4j.security.handler.RestfulAccessDeniedHandler;
import cn.yt4j.security.property.JwtAuthFilterProperty;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author gyv12345@163.com
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Yt4jSecurityConfig{

	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	private final UserDetailsService userDetailsService;

	private final PasswordEncoder encoder;

	private final JwtAuthFilterProperty jwtAuthFilterProperty;

	private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

	private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
				.authorizeRequests();
		// 不需要保护的资源路径允许访问
		Optional.ofNullable(jwtAuthFilterProperty.getIgnoredUrl()).orElse(new ArrayList<>())
				.forEach(url -> registry.requestMatchers(url).permitAll());

		// 允许跨域请求的OPTIONS请求
		registry.requestMatchers(HttpMethod.OPTIONS).permitAll();
		// 任何请求需要身份认证
		registry.and().authorizeRequests().anyRequest().authenticated()
				// 关闭跨站请求防护及不使用session
				.and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				// 自定义权限拒绝处理类
				.and().exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler)
				.authenticationEntryPoint(restAuthenticationEntryPoint)
				// 自定义权限拦截器JWT过滤器
				.and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@SneakyThrows
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}


}
