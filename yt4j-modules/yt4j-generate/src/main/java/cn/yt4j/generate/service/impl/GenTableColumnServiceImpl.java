package cn.yt4j.generate.service.impl;

import cn.yt4j.generate.entity.GenTableColumn;
import cn.yt4j.generate.mapper.GenTableColumnMapper;
import cn.yt4j.generate.service.GenTableColumnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Service
public class GenTableColumnServiceImpl extends ServiceImpl<GenTableColumnMapper, GenTableColumn>
		implements GenTableColumnService {

	@Override
	public List<GenTableColumn> selectDbTableColumnsByName(String tableName) {
		return this.baseMapper.selectDbTableColumnsByName(tableName);
	}

}
