package cn.yt4j.gateway.filter;

import cn.dev33.satoken.same.SaSameUtil;
import cn.yt4j.core.constant.TracingConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * 全局过滤器，为请求添加 Id-Token
 *
 * @author gyv12345@163.com
 */
@Slf4j
@Component
public class ForwardAuthFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String traceId = UUID.randomUUID().toString();
		MDC.put(TracingConstants.TRACE_ID, traceId);
		log.info("ForwardAuthFilter");

		ServerHttpRequest newRequest = exchange.getRequest().mutate()
				// 为请求追加 Id-Token 参数
				.header(SaSameUtil.SAME_TOKEN, SaSameUtil.getToken()).header(TracingConstants.TRACE_ID, traceId)
				.build();
		ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
		return chain.filter(newExchange).doFinally(signalType -> MDC.remove(TracingConstants.TRACE_ID));
	}

}
