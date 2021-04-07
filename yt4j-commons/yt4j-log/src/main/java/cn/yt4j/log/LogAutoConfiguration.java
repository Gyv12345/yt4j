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
 * 很多框架都是将日志写入数据库，但是在实际开发的时候，发现写入数据库参数那个字段的长度，使用text可能会不够。
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
