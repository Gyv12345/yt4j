
package cn.yt4j.core.domain;

import cn.yt4j.core.enums.IMessageStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 返回信息
 *
 * @author gyv12345@163.com
 */
@Schema(description = "结果实体")
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@ToString(callSuper = true)
@Getter
@Setter
public class R<T> implements Serializable {

	private static final long serialVersionUID = -6101337183914807339L;

	@Schema(description = "编码")
	private int code;

	@Schema(description = "返回信息")
	private String message;

	@Schema(description = "结果")
	private T data;

	public static <T> R<T> ok() {
		return result(null, HttpStatus.OK.value(), null);
	}

	public static <T> R<T> ok(T data) {
		if (data instanceof Boolean) {
			if (Boolean.FALSE.equals(data)) {
				return result(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "出现错误，可能是演示环境引起的");
			}
		}
		return result(data, HttpStatus.OK.value(), null);
	}

	public static <T> R<T> ok(String message) {
		return result(null, HttpStatus.OK.value(), message);
	}

	public static R<String> success(String message) {
		return result(message, HttpStatus.OK.value(), null);
	}

	public static <T> R<PageResult<T>> ok(IPage<T> page) {
		PageResult<T> data = new PageResult<>(page);
		return result(data, HttpStatus.OK.value(), "查询成功");
	}

	public static <T> R<T> ok(T data, String message) {
		return result(data, HttpStatus.OK.value(), message);
	}

	public static <T> R<T> failed() {
		return result(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
	}

	public static <T> R<T> failed(String message) {
		return result(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public static <T> R<T> failed(T data) {
		return result(data, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
	}

	public static <T> R<T> failed(T data, String message) {
		return result(data, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public static <T> R<T> failed(IMessageStatus status) {
		return result(null, status);
	}

	public static <T> R<T> result(T data, IMessageStatus status) {
		return result(data, status.getCode(), status.getMessage());
	}

	private static <T> R<T> result(T data, int code, String message) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMessage(message);
		return apiResult;
	}

}
