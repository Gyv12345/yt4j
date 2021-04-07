/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.flow.work;

/**
 * 工作上下文
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
