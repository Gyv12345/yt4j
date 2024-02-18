package cn.yt4j.sys.api.service;

import cn.yt4j.core.domain.Result;
import cn.yt4j.sa.config.FeignInterceptor;
import cn.yt4j.sys.api.entity.vo.SysConfigVO;
import cn.yt4j.sys.api.service.impl.SysConfigClientImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gyv12345@163.com
 */
@Tag(name = "配置feign")
@FeignClient(name = "yt4j-sys", contextId = "sys-config", configuration = FeignInterceptor.class,
		fallback = SysConfigClientImpl.class)
public interface SysConfigClient {

	/**
	 * 根据key获取配置
	 * @param key key
	 * @return
	 */
	@GetMapping("/config/key")
	Result<SysConfigVO> getSysConfigByKey(@RequestParam("key") String key);

}
