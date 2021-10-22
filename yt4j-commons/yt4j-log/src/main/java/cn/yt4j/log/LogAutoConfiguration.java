/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.log;

import cn.yt4j.log.aspect.SysLogAspect;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 记录传递参数，返回结果，方便后期查询
 * 使用Plumelog方便从es进行筛选
 * 想着只需要写入日志文件，再使用elk这样的进行日志收集之后展示吧
 *
 * @author gyv12345@163.com
 */
@Order
@Configuration
@RequiredArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

	@Bean
	public SysLogAspect sysLogAspect(ObjectMapper objectMapper) {
		return new SysLogAspect(objectMapper);
	}

}
