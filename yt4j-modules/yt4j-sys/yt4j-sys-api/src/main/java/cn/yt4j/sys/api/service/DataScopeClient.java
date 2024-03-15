package cn.yt4j.sys.api.service;

import cn.yt4j.sa.config.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author gyv12345@163.com
 */
@FeignClient(name = "yt4j-sys-svc", contextId = "dataScope", configuration = FeignInterceptor.class)
public interface DataScopeClient {

}
