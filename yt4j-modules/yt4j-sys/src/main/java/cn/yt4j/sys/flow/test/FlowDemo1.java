/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.flow.test;

import cn.yt4j.flow.work.Work;
import cn.yt4j.flow.work.WorkContext;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.FlowTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author gyv12
 */
@Slf4j
@Component
public class FlowDemo1 implements Work<FlowTestDTO, SysUser> {
    @Override
    public int execute(WorkContext<FlowTestDTO, SysUser> context) {
        log.info("大于10岁");
        context.getResponse().setNickName("网二");
        return NEXT;
    }
}
