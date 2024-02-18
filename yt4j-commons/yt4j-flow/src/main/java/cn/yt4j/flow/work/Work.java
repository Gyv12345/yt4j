
package cn.yt4j.flow.work;

import java.util.Map;

/**
 * 工作接口
 *
 * @author gyv12345@163.com
 */
public interface Work {

	/**
	 * 指向下一个页面的标志
	 */
	int NEXT = 1;

	/**
	 * 退出页面的标志
	 */
	int EXIT = 0;

	/**
	 * 执行
	 * @param context 上下文
	 * @return 执行成功结果
	 */
	int execute(Map<String, Object> context);

}
