package cn.yt4j.generate.mapper;

import cn.yt4j.generate.entity.GenTableColumn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 代码生成业务字段表
 * @author gyv12345@163.com
 */
@Mapper
public interface GenTableColumnMapper extends BaseMapper<GenTableColumn> {

	/**
	 * 按表名查询字段信息
	 * @param tableName 表名
	 * @return 结果
	 */
	List<GenTableColumn> selectDbTableColumnsByName(String tableName);

}
