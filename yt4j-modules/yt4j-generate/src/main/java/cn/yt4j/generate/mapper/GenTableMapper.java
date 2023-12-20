package cn.yt4j.generate.mapper;

import cn.yt4j.generate.entity.GenTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 代码生成表结构
 * @author gyv12345@163.com
 */
@Mapper
public interface GenTableMapper extends BaseMapper<GenTable> {

	/**
	 * 查询数据库元数据
	 * @param page 分页参数
	 * @param genTable 分页表名称
	 * @return 分页数据
	 */
	Page<GenTable> selectTablePage(@Param("page") IPage<GenTable> page, @Param("genTable") GenTable genTable);

}
