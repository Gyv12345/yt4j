package cn.yt4j.feishu.client;

import cn.yt4j.feishu.client.fallback.FeiShuClientFallback;
import cn.yt4j.sa.config.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 飞书的feign接口
 *
 * @author gyv12345@163.com
 */
@FeignClient(name = "yt4j-feishu-svc", contextId = "feishuClient", configuration = FeignInterceptor.class,
        fallback = FeiShuClientFallback.class)
public interface FeiShuClient {

}
