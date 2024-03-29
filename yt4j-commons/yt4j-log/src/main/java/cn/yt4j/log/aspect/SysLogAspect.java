
package cn.yt4j.log.aspect;

import cn.yt4j.log.annotation.SysLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 操作日志
 *
 * @author gyv12345@163.com
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
@Component
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

		Object obj = point.proceed();
		log.info("结果:[{}]", objectMapper.writeValueAsString(obj));
		log.info("-------------- 结束 {} -------------------", sysLog.value());
		return obj;
	}

}
