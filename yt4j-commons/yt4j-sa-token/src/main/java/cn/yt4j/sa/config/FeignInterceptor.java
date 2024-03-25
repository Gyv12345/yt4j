package cn.yt4j.sa.config;

import cn.dev33.satoken.same.SaSameUtil;
import cn.yt4j.core.constant.TracingConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * feign拦截器, 在feign请求发出之前，加入一些操作
 *
 * @author gyv12345@163.com
 */
@Component
@Slf4j
public class FeignInterceptor implements RequestInterceptor {

	/**
	 * 为 Feign 的 RCP调用 添加请求头SA-SAME-TOKEN
	 */
	@Override
	public void apply(RequestTemplate requestTemplate) {
		requestTemplate.header(TracingConstants.TRACE_ID, MDC.get(TracingConstants.TRACE_ID));
		requestTemplate.header(SaSameUtil.SAME_TOKEN, SaSameUtil.getToken());
	}

}
