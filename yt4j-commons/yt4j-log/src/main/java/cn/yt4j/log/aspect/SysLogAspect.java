/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.log.aspect;

import cn.yt4j.log.annotation.SysLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 操作日志
 *
 * @author gyv12345@163.com
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class SysLogAspect {

	private final ObjectMapper objectMapper;

	@SneakyThrows
	@Around("@annotation(sysLog)")
	public Object around(ProceedingJoinPoint point, SysLog sysLog) {
		String strClassName = point.getTarget().getClass().getName();
		String strMethodName = point.getSignature().getName();
		log.info("-------------- 开始执行 {} -------------------", sysLog.value());
		log.info("类名:[{}],方法:[{}]", strClassName, strMethodName);
		log.info("参数:[{}]", objectMapper.writeValueAsString(point.getArgs()));

		Long startTime = System.currentTimeMillis();
		Object obj = point.proceed();
		Long endTime = System.currentTimeMillis();
		log.info("用时:[{}ms],结果:[{}]", endTime - startTime, objectMapper.writeValueAsString(obj));
		log.info("-------------- 结束 {} -------------------", sysLog.value());
		return obj;
	}

}
