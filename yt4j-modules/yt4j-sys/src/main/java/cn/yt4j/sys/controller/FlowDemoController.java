/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.controller;

import cn.yt4j.core.constant.RedisConstants;
import cn.yt4j.core.domain.R;
import cn.yt4j.flow.work.FlowTool;
import cn.yt4j.flow.work.WorkContext;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.FlowTestDTO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 简单demo演示
 * @author @author gyv12345@163.com
 */
@Api(tags = " 业务流程DEMO")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/flow")
public class FlowDemoController {

    private final FlowTool flowTool;

    private final RedisTemplate<String,String> redisTemplate;

    @GetMapping("test")
    public R test(FlowTestDTO info, HttpServletRequest request){
        WorkContext context=new WorkContext(info,new SysUser());
        flowTool.getByName("test").execute(context);
        return R.ok(context.getResponse());
    }

    @GetMapping("message")
    public R message(){
        redisTemplate.convertAndSend(RedisConstants.MESSAGE_TOPIC,"hello world");
        return R.ok();
    }
}
