package cn.yt4j.generate.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.generate.entity.GenTable;
import cn.yt4j.generate.mapper.GenTableMapper;
import cn.yt4j.generate.service.GenTableService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 数据表
 * @author gyv12345@163.com
 */
@Service
public class GenTableServiceImpl extends ServiceImpl<GenTableMapper, GenTable> implements GenTableService {

	@DS("#genTable.datasourceName")
	@Override
	public Page<GenTable> selectTablePage(IPage<GenTable> page, GenTable genTable) {
		if (ObjectUtil.isEmpty(genTable.getDatasourceName())){
			return new Page<>();
		}
		return this.baseMapper.selectTablePage(page, genTable);
	}

	@Override
	public List<Map<String, Object>> tables(String tableName) {
		return null;
	}

}
