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
