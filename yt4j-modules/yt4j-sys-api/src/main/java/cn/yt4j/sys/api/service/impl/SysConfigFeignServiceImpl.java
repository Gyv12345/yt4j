package cn.yt4j.sys.api.service.impl;

import cn.yt4j.core.domain.Result;
import cn.yt4j.sys.api.entity.vo.SysConfigVO;
import cn.yt4j.sys.api.service.SysConfigFeignService;
import org.springframework.stereotype.Service;

/**
 * @author gyv12345@163.com
 */
@Service
public class SysConfigFeignServiceImpl implements SysConfigFeignService {
    @Override
    public Result<SysConfigVO> getSysConfigByKey(String key) {
        return Result.ok();
    }
}
