
package cn.yt4j.flow.work;

import lombok.Getter;

/**
 * 流程上下文
 *
 * @author gyv12345@163.com
 */
@Getter
public class WorkContext<T, E> {

	private final T request;

	private final E response;

	public WorkContext(T request, E response) {
		this.request = request;
		this.response = response;
	}

}
