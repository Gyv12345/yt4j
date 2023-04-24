
package cn.yt4j.flow.work;

import java.util.Map;

/**
 * @author gyv12345@163.com
 */
public interface Work {

	int NEXT = 1;

	int EXIT = 0;

	/**
	 * 执行
	 * @param context
	 * @return
	 */
	int execute(Map<String, Object> context);

}
