package cn.yt4j.feishu.client;

import cn.yt4j.core.domain.Result;
import cn.yt4j.plugin.common.entity.BaseDept;
import cn.yt4j.plugin.common.entity.BaseUser;
import cn.yt4j.sa.config.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 飞书的feign接口
 *
 * @author gyv12345@163.com
 */
@FeignClient(name = "yt4j-feishu-svc", contextId = "feishuClient", configuration = FeignInterceptor.class)
public interface FeiShuClient {
    /**
     * 判断飞书模块是否存在
     *
     * @return
     */
    Result<Boolean> checkFeiShu();

    /**
     * 获取部门信息
     */
    Result<List<BaseDept>> getDept(String deptId);

    /**
     * 获取用户信息
     */
    Result<List<BaseUser>> getUser(String deptId);

}
