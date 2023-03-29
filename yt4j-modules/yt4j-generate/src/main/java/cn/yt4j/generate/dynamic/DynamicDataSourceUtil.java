package cn.yt4j.generate.dynamic;

import cn.yt4j.generate.constants.DataSourceConstants;
import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class DynamicDataSourceUtil {
    private final DataSource dataSource;

    private final DataSourceCreator hikariDataSourceCreator;

    public void addDataSource(String in) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        Map<String,String> map= JSON.parseObject(in, Map.class);
        DataSourceProperty property=new DataSourceProperty();
        property.setUsername(map.get(DataSourceConstants.DS_USER_NAME));
        property.setPassword(map.get(DataSourceConstants.DS_USER_PWD));
        property.setUrl(map.get(DataSourceConstants.DS_JDBC_URL));
        log.info(property.toString());
        DataSource dataSource = hikariDataSourceCreator.createDataSource(property);
        ds.addDataSource(map.get(DataSourceConstants.POOL_NAME), dataSource);
        log.info(ds.getDataSources().toString());
    }
}
