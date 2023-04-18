package cn.yt4j.generate.dynamic;

import cn.yt4j.generate.entity.GenDatasource;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class DynamicDataSourceUtil {

	private final DataSource dataSource;

	private final DataSourceCreator hikariDataSourceCreator;

	public void addDataSource(GenDatasource genDatasource) {
		DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
		DataSourceProperty property = new DataSourceProperty();
		property.setUsername(genDatasource.getUsername());
		property.setPassword(genDatasource.getPassword());
		property.setUrl(genDatasource.getUrl());
		DataSource dataSource = hikariDataSourceCreator.createDataSource(property);
		ds.addDataSource(genDatasource.getName(), dataSource);
		log.info(ds.getDataSources().toString());
	}

	public void removeDataSource(String dataSourceName) {
		DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
		ds.removeDataSource(dataSourceName);
	}

}
