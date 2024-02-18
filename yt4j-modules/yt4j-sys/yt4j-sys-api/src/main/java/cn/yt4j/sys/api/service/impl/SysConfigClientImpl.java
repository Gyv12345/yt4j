package cn.yt4j.sys.api.service.impl;

import cn.yt4j.core.domain.Result;
import cn.yt4j.sys.api.entity.vo.SysConfigVO;
import cn.yt4j.sys.api.service.SysConfigClient;
import org.springframework.stereotype.Component;

/**
 * @author gyv12345@163.com
 */
@Component
public class SysConfigClientImpl implements SysConfigClient {

	@Override
	public Result<SysConfigVO> getSysConfigByKey(String key) {
		return Result.ok();
	}

}
