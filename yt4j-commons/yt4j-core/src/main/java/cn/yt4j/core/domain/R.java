/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.core.domain;

import cn.yt4j.core.enums.IMessageStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@ToString(callSuper = true)
@Getter
@Setter
@ApiModel(value = "响应信息")
public class R<T> implements Serializable {

	private static final long serialVersionUID = -6101337183914807339L;

	@ApiModelProperty("编码")
	private int status;

	@ApiModelProperty("返回信息")
	private String message;

	@ApiModelProperty("返回数据")
	private T result;

	public static <T> R<T> ok() {
		return result(null, HttpStatus.OK.value(), null);
	}

	public static <T> R<T> ok(T result) {
		if (result instanceof Boolean) {
			if (Boolean.FALSE.equals(result)) {
				return result(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "出现错误，可能是演示环境引起的");
			}
		}
		return result(result, HttpStatus.OK.value(), null);
	}

	public static <T> R<T> ok(String message) {
		return result(null, HttpStatus.OK.value(), message);
	}

	public static <T> R<PageResult<T>> ok(IPage<T> page) {
		PageResult<T> result = new PageResult<>(page);
		return result(result, HttpStatus.OK.value(), "查询成功");
	}

	public static <T> R<T> ok(T result, String message) {
		return result(result, HttpStatus.OK.value(), message);
	}

	public static <T> R<T> failed() {
		return result(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
	}

	public static <T> R<T> failed(String message) {
		return result(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public static <T> R<T> failed(T result) {
		return result(result, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
	}

	public static <T> R<T> failed(T result, String message) {
		return result(result, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public static <T> R<T> failed(IMessageStatus status) {
		return result(null, status);
	}

	public static <T> R<T> result(T result, IMessageStatus status) {
		return result(result, status.getStatus(), status.getMessage());
	}

	private static <T> R<T> result(T result, int status, String message) {
		R<T> apiResult = new R<>();
		apiResult.setStatus(status);
		apiResult.setResult(result);
		apiResult.setMessage(message);
		return apiResult;
	}

}
