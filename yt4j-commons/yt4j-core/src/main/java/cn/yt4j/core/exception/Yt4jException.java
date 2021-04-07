/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.core.exception;

import cn.yt4j.core.enums.IMessageStatus;

/**
 * @author gyv12345@163.com
 */
public class Yt4jException extends RuntimeException {

	private IMessageStatus messageStatus;

	public Yt4jException() {
	}

	public Yt4jException(String message) {
		super(message);
	}

	public Yt4jException(IMessageStatus messageStatus) {
		this.messageStatus = messageStatus;
	}

	public IMessageStatus getMessageStatus() {
		return messageStatus;
	}

}
