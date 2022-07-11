/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.data.batch;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于mysql的批量添加，现在仅支持无主键生成策略 但是还是判断了一下主键生成策略，应该说，如果主键上有自增类型，那么sql就没有主键字段了 主要还是构建语句
 *
 * @author gyv12345@163.com
 */
public class Yt4jInsertBatch extends AbstractMethod {

	private List<String> filter = new ArrayList<>() {
		{
			add("create_time");
			add("update_time");
		}
	};

	@Override
	public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
		SqlMethod sqlMethod = SqlMethod.INSERT_ONE;
		Boolean auto = tableInfo.getIdType().equals(IdType.AUTO);
		final String fieldSql = prepareFieldSql(tableInfo, auto);
		final String valueSql = prepareValuesSqlForMysqlBatch(tableInfo, auto);
		final String sqlResult = String.format(sqlMethod.getSql(), tableInfo.getTableName(), fieldSql, valueSql);
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
		return this.addInsertMappedStatement(mapperClass, modelClass, "batchInsertByMysql", sqlSource,
				new NoKeyGenerator(), null, null);
	}

	private String prepareFieldSql(TableInfo tableInfo, Boolean auto) {
		StringBuilder fieldSql = new StringBuilder();
		if (!auto) {
			fieldSql.append(tableInfo.getKeyColumn()).append(",");
		}
		tableInfo.getFieldList().forEach(x -> {
			if (!filter.contains(x.getColumn())) {
				fieldSql.append(x.getColumn()).append(",");
			}
		});
		fieldSql.delete(fieldSql.length() - 1, fieldSql.length());
		fieldSql.insert(0, "(");
		fieldSql.append(")");
		return fieldSql.toString();
	}

	private String prepareValuesSqlForMysqlBatch(TableInfo tableInfo, Boolean auto) {
		final StringBuilder valueSql = new StringBuilder();
		valueSql.append(
				"<foreach collection=\"list\" item=\"item\" index=\"index\" open=\"(\" separator=\"),(\" close=\")\">");
		if (!auto) {
			valueSql.append("#{item.").append(tableInfo.getKeyProperty()).append("},");
		}
		tableInfo.getFieldList().forEach(x -> {
			if (!filter.contains(x.getColumn())) {
				valueSql.append("#{item.").append(x.getProperty()).append("},");
			}
		});
		valueSql.delete(valueSql.length() - 1, valueSql.length());
		valueSql.append("</foreach>");
		return valueSql.toString();
	}

}
