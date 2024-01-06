
package cn.yt4j.flow.work;

import lombok.Getter;

/**
 * 流程上下文
 *
 * @author gyv12345@163.com
 */
@Getter
public class WorkContext<T, E> {

	/**
	 * 请求对象
	 */
	private final T request;

	/**
	 * 响应对象
	 */
	private final E response;

	public WorkContext(T request, E response) {
		this.request = request;
		this.response = response;
	}

}
