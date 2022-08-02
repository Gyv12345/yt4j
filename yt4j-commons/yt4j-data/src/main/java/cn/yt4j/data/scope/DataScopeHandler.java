package cn.yt4j.data.scope;

import net.sf.jsqlparser.expression.Expression;

/**
 * 数据权限处理器
 *
 * @author gyv12345@163.com
 */
public interface DataScopeHandler {

	/**
	 * 获取数据权限 SQL 片段
	 * @param where 待执行 SQL Where 条件表达式
	 * @param dataScope 数据权限的实体
	 * @return JSqlParser 条件表达式
	 */
	Expression getSqlSegment(Expression where, DataScope dataScope);

}
