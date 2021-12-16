/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
