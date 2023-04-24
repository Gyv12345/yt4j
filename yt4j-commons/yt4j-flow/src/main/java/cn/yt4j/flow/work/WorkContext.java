
package cn.yt4j.flow.work;

/**
 * 流程上下文
 *
 * @author gyv12345@163.com
 */
public class WorkContext<T extends Object, E extends Object> {

	private T request;

	private E response;

	public WorkContext(T request, E response) {
		this.request = request;
		this.response = response;
	}

	public T getRequest() {
		return request;
	}

	public E getResponse() {
		return response;
	}

}
