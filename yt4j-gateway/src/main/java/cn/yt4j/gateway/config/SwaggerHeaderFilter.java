/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.gateway.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author fsl
 * @description: SwaggerHeaderFilter
 * @date 2019-06-0310:47
 */
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {

	private static final String HEADER_NAME = "X-Forwarded-Prefix";

	private static final String URI = "/v2/api-docs";

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			String path = request.getURI().getPath();
			if (!StringUtils.endsWithIgnoreCase(path, URI)) {
				return chain.filter(exchange);
			}
			String basePath = path.substring(0, path.lastIndexOf(URI));
			ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
			ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
			return chain.filter(newExchange);
		};
	}

}
