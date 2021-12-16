/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.flow.work;

/**
 * 流程上下文
 *
 * @author gyv12345@163.com
 */
public class WorkContext<T extends Object, E extends Object> {

	private T data;

	private E response;

	public WorkContext(T data, E response) {
		this.data = data;
		this.response = response;
	}

	public T getData() {
		return data;
	}

	public E getResponse() {
		return response;
	}

}
