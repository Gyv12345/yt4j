/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.core.enums;

/**
 * 消息
 * @author gyv12345@163.com
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum MessageStatus implements IMessageStatus {

	LOGIN_FAILED(401, "未登录登录失败"), ACCESS_FAILED(403, "登录失败，没有这个用户"), PASSWORD_FAILED(1100, "旧密码错误"), FAILED(500,
			"操作失败"), SUCCESS(200, "执行成功"), SELECT_SUCCESS(200, "查询成功"), SELECT_FAILED(500, "查询失败"), ADD_SUCCESS(200,
					"添加成功"), ADD_FAILED(500, "添加失败"), UPDATE_SUCCESS(200, "修改成功"), UPDATE_FAILED(500,
							"修改失败"), DELETE_SUCCESS(200, "删除成功"), DELETE_FAILED(500, "删除失败");

	private final int status;

	private final String message;

	MessageStatus(final int status, final String message) {
		this.status = status;
		this.message = message;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
