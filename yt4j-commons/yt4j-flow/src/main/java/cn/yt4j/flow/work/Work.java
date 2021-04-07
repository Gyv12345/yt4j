package cn.yt4j.flow.work;

/**
 * @author gyv12345@163.com
 */
public interface Work<T, E> {

	int NEXT = 1;

	int EXIT = 0;

	/**
	 * 执行
	 * @param context
	 * @return
	 */
	int execute(WorkContext<T, E> context);

}
