/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sa.handle;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.yt4j.core.domain.R;
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
	public R notLoginException(NotLoginException e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return R.failed(MessageStatus.ACCESS_FAILED);
	}

	@ExceptionHandler(NotRoleException.class)
	public R notRoleException(NotRoleException e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return R.failed(SaExceptionEnum.NOT_ROLE);
	}

	@ExceptionHandler(NotPermissionException.class)
	public R notPermissionException(NotPermissionException e) {
		log.error("异常信息 ex={}", e.getMessage(), e);
		return R.failed(SaExceptionEnum.NOT_PERMISSION);
	}

}
