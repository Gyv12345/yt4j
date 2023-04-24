package cn.yt4j.generate.service.impl;

import cn.yt4j.generate.entity.GenTable;
import cn.yt4j.generate.mapper.GenTableMapper;
import cn.yt4j.generate.service.GenTableService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gyv12345@163.com
 * @description 针对表【gen_table(代码生成业务表)】的数据库操作Service实现
 * @createDate 2023-03-28 09:38:00
 */
@Service
public class GenTableServiceImpl extends ServiceImpl<GenTableMapper, GenTable> implements GenTableService {

	@DS("#datasourceName")
	@Override
	public List<Map<String, Object>> queryTables(String datasourceName) {
		return null;
	}

	@Override
	public List<Map<String, Object>> tables(String tableName) {
		return null;
	}

}
