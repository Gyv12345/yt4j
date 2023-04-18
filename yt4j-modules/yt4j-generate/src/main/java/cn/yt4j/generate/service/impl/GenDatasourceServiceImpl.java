package cn.yt4j.generate.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.generate.dynamic.DynamicDataSourceUtil;
import cn.yt4j.generate.entity.GenDatasource;
import cn.yt4j.generate.mapper.GenDatasourceMapper;
import cn.yt4j.generate.service.GenDatasourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 数据源操作服务
 *
 * @author gyv12345@163.com
 */
@RequiredArgsConstructor
@Service
public class GenDatasourceServiceImpl extends ServiceImpl<GenDatasourceMapper, GenDatasource>
		implements GenDatasourceService {

	private final DynamicDataSourceUtil dynamicDataSourceUtil;

	@Override
	public void addOrUpdate(GenDatasource datasource) {
		if (ObjectUtil.isNotEmpty(datasource.getId())) {
			GenDatasource old = this.baseMapper.selectById(datasource.getId());
			this.baseMapper.updateById(datasource);
			dynamicDataSourceUtil.removeDataSource(old.getName());
			dynamicDataSourceUtil.addDataSource(datasource);
		}
		else {
			this.baseMapper.insert(datasource);
			dynamicDataSourceUtil.addDataSource(datasource);
		}
	}

}
