package cn.yt4j.gateway.filter;

import cn.yt4j.gateway.util.WebFluxUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * 在filter中获取前置预言里面的请求body
 *
 * @author gyv12345@163.com
 */
@Component
@Slf4j
public class WrapperRequestGlobalFilter implements GlobalFilter, Ordered {

	/**
	 * 优先级最高
	 */
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 1;
	}

	@SneakyThrows
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		URI URIPath = request.getURI();
		String path = request.getPath().value();
		String method = request.getMethod().name();
		HttpHeaders header = request.getHeaders();
		String ip = WebFluxUtil.getIpAddress(exchange.getRequest());

		log.info("***********************************请求信息**********************************");
		log.info("请求request信息：URI = {}, path = {}，method = {}，header = {}，ip = {} 。", URIPath, path, method, header,
				ip);
		log.info("****************************************************************************\n");
		return chain.filter(exchange);
	}

}
