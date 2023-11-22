
package cn.yt4j.flow.work;

import lombok.Getter;

/**
 * @author gyv12345@163.com
 */
@Getter
public abstract class AbstractWorkFlow implements WorkFlow {

	private final String name;

	private final String id;

	AbstractWorkFlow(String name, String id) {
		this.name = name;
		this.id = id;
	}

}
