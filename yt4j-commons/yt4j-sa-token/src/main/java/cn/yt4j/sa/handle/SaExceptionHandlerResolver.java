
package cn.yt4j.sa.handle;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.yt4j.core.domain.Result;
import cn.yt4j.core.enums.MessageStatus;
import cn.yt4j.sa.enums.SaExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@RestControllerAdvice
public class SaExceptionHandlerResolver {

	@ExceptionHandler(NotLoginException.class)
	public Result<Void> notLoginException(NotLoginException e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return Result.failed(MessageStatus.LOGIN_FAILED);
	}

	@ExceptionHandler(NotRoleException.class)
	public Result<Void> notRoleException(NotRoleException e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return Result.failed(SaExceptionEnum.NOT_ROLE);
	}

	@ExceptionHandler(NotPermissionException.class)
	public Result<Void> notPermissionException(NotPermissionException e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return Result.failed(SaExceptionEnum.NOT_PERMISSION);
	}

}
