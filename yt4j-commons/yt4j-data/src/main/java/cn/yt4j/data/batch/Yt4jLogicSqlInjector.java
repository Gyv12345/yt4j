
package cn.yt4j.data.batch;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
public class Yt4jLogicSqlInjector extends DefaultSqlInjector {

	/**
	 * 如果只需增加方法，保留MP自带方法 可以super.getMethodList() 再add
	 * @return
	 */
	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
		methodList.add(new Yt4jInsertBatch());
		return methodList;
	}

}
