package cn.yt4j.data.interceptor;

import cn.yt4j.data.scope.DataScope;
import cn.yt4j.data.scope.DataScopeHandler;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.parser.JsqlParserSupport;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import lombok.Data;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SetOperationList;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 数据权限
 *
 * @author gyv12345@163.com
 */
@Data
public class DataScopeInterceptor extends JsqlParserSupport implements InnerInterceptor {

	private DataScopeHandler dataScopeHandler;

	@Override
	public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds,
			ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
		// 判断是否包含dataScope实体
		DataScope dataScope = findDataScopeObject(parameter);
		if (null == dataScope) {
			// 没有实体不做处理
			return;
		}

		PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
		mpBs.sql(parserSingle(mpBs.sql(), dataScope));
	}

	@Override
	protected void processSelect(Select select, int index, String sql, Object obj) {
		SelectBody selectBody = select.getSelectBody();
		if (selectBody instanceof PlainSelect selectBodyConvert) {
			this.setWhere(selectBodyConvert, (DataScope) obj);
		}
		else if (selectBody instanceof SetOperationList) {
			SetOperationList setOperationList = (SetOperationList) selectBody;
			List<SelectBody> selectBodyList = setOperationList.getSelects();
			selectBodyList.forEach(s -> this.setWhere((PlainSelect) s, (DataScope) obj));
		}
	}

	/**
	 * 设置 where 条件
	 * @param plainSelect 查询对象
	 * @param dataScope 数据那啥哦
	 */
	protected void setWhere(PlainSelect plainSelect, DataScope dataScope) {
		Expression sqlSegment = dataScopeHandler.getSqlSegment(plainSelect.getWhere(), dataScope);
		if (null != sqlSegment) {
			plainSelect.setWhere(sqlSegment);
		}
	}

	/**
	 * 查找参数是否包括DataScope对象
	 * @param parameterObj 参数列表
	 * @return DataScope
	 */
	private DataScope findDataScopeObject(Object parameterObj) {
		if (parameterObj instanceof DataScope dataScope) {
			return dataScope;
		}
		else if (parameterObj instanceof Map) {
			for (Object val : ((Map<?, ?>) parameterObj).values()) {
				if (val instanceof DataScope dataScope) {
					return dataScope;
				}
			}
		}
		return null;
	}

}
