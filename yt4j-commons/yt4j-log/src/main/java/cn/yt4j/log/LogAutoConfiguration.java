/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
