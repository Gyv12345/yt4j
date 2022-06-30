package cn.yt4j.sa.config;

import cn.dev33.satoken.id.SaIdUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * feign拦截器, 在feign请求发出之前，加入一些操作
 * @author gyv12345@163.com
 */
@Component
public class FeignInterceptor implements RequestInterceptor {
    /**
     * 为 Feign 的 RCP调用 添加请求头Id-Token
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(SaIdUtil.ID_TOKEN, SaIdUtil.getToken());
    }
}

