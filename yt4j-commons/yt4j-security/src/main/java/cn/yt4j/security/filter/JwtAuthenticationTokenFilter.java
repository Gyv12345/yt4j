/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.security.filter;

import cn.yt4j.security.property.JwtAuthFilterProperty;
import cn.yt4j.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gyv12345@163.com
 */
@RequiredArgsConstructor
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final UserDetailsService userDetailsService;

	private final JwtAuthFilterProperty jwtAuthFilterProperty;

	private final JwtUtil jwtUtil;

	/**
	 * 过滤器逻辑
	 * @param request .
	 * @param response .
	 * @param chain .
	 * @throws ServletException .
	 * @throws IOException ,
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String authHeader = request.getHeader(this.jwtAuthFilterProperty.getHeader());
		String tokenHead = this.jwtAuthFilterProperty.getTokenHead();
		if (authHeader != null && authHeader.startsWith(tokenHead)) {
			String authToken = authHeader.substring(tokenHead.length());
			if (jwtUtil.validateToken(authToken)) {
				String subject = jwtUtil.getSubjectFromToken(authToken);
				UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}

}
