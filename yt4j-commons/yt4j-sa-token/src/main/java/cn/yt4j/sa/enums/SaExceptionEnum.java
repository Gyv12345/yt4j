
package cn.yt4j.sa.enums;

import cn.yt4j.core.enums.IMessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gyv12345@163.com
 */
@Getter
@AllArgsConstructor
public enum SaExceptionEnum implements IMessageStatus {

	NOT_ROLE(401, "您无权限进行操作"), NOT_PERMISSION(401, "您无权限进行操作"),;

	private int code;

	private String message;

}
