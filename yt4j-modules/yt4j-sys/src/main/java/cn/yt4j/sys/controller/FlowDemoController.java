/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.yt4j.core.constant.RedisConstants;
import cn.yt4j.core.domain.R;
import cn.yt4j.flow.work.FlowTool;
import cn.yt4j.sys.entity.dto.FlowTestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 简单demo演示
 * @author gyv12345@163.com
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/flow")
public class FlowDemoController {

    private final FlowTool flowTool;

    private final RedisTemplate<String,String> redisTemplate;

    /**
     * 测试什么
     * @param info
     * @param request
     * @return
     */
    @GetMapping("test")
    public R test(FlowTestDTO info, HttpServletRequest request){
        Map<String,Object> context= BeanUtil.beanToMap(info);
        flowTool.getByName("test").execute(context);
        return R.ok(context);
    }

    @GetMapping("message")
    public R message(){
        redisTemplate.convertAndSend(RedisConstants.MESSAGE_TOPIC,"hello world");
        return R.ok();
    }
}
