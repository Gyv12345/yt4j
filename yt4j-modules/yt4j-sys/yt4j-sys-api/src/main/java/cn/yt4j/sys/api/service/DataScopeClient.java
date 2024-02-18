package cn.yt4j.sys.api.service;

import cn.yt4j.sa.config.FeignInterceptor;
import cn.yt4j.sys.api.service.impl.DataScopeClientImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author gyv12345@163.com
 */
@FeignClient(name = "yt4j-sys", contextId = "dataScope", configuration = FeignInterceptor.class,
		fallbackFactory = DataScopeClientImpl.class)
public interface DataScopeClient {

}
