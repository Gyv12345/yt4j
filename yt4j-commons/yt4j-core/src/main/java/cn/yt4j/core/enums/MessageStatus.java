
package cn.yt4j.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息
 *
 * @author gyv12345@163.com
 */
@AllArgsConstructor
@Getter
public enum MessageStatus implements IMessageStatus {

	/**
	 * 登录失败
	 */
	LOGIN_FAILED(401, "登录失败，用户名或密码错误"),
	/**
	 * 登录失败
	 */
	ACCESS_FAILED(403, "登录失败，没有这个用户"),
	/**
	 * 密码错误
	 */
	PASSWORD_FAILED(1100, "旧密码错误"),
	/**
	 * 操作成功
	 */
	FAILED(500, "操作失败"),
	/**
	 * 执行成功
	 */
	SUCCESS(200, "执行成功"),
	/**
	 * 查询成功
	 */
	SELECT_SUCCESS(200, "查询成功"),
	/**
	 * 查询失败
	 */
	SELECT_FAILED(500, "查询失败"),
	/**
	 * 添加成功
	 */
	ADD_SUCCESS(200, "添加成功"),
	/**
	 * 添加失败
	 */
	ADD_FAILED(500, "添加失败"),
	/**
	 * 修改成功
	 */
	UPDATE_SUCCESS(200, "修改成功"),
	/**
	 * 修改失败
	 */
	UPDATE_FAILED(500, "修改失败"),
	/**
	 * 删除成功
	 */
	DELETE_SUCCESS(200, "删除成功"),
	/**
	 * 删除失败
	 */
	DELETE_FAILED(500, "删除失败"),;

	private final int code;

	private final String message;

}
