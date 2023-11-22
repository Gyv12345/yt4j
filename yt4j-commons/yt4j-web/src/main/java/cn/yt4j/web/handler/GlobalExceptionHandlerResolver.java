
package cn.yt4j.web.handler;

import cn.yt4j.core.domain.Result;
import cn.yt4j.core.exception.Yt4jException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerResolver {

	/**
	 * 全局异常.
	 * @param e the e
	 * @return R
	 */
	@ExceptionHandler(Exception.class)
	public Result<Void> handleGlobalException(Exception e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return Result.failed(e.getLocalizedMessage());
	}

	/**
	 * AccessDeniedException
	 * @param e the e
	 * @return R
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public Result<Void> handleAccessDeniedException(AccessDeniedException e) {
		log.error("拒绝授权异常信息 ex={}", e.getMessage(), e);
		return Result.failed(e.getLocalizedMessage());
	}

	/**
	 * validation Exception
	 * @param exception 异常
	 * @return R
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public Result<Void> handleBodyValidException(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
		log.error(exception.getMessage(), exception);
		return Result.failed(fieldErrors.get(0).getDefaultMessage());
	}

	/**
	 * validation Exception (以form-data形式传参)
	 * @param exception 异常
	 * @return R
	 */
	@ExceptionHandler({ BindException.class })
	public Result<Void> bindExceptionHandler(BindException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
		log.error(exception.getMessage(), exception);
		return Result.failed(fieldErrors.get(0).getDefaultMessage());
	}

	/**
	 * 自定义异常.
	 * @param e the e
	 * @return R
	 */
	@ExceptionHandler(Yt4jException.class)
	public Result ysgExceptionHandler(Yt4jException e) {
		log.error("业务异常信息 ex={}", e.getMessage(), e);
		return Result.failed(e.getMessageStatus());
	}

}
