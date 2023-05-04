package cn.yt4j.generate.mapper;

import cn.yt4j.generate.entity.GenTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author gyv12345@163.com
 * @description 针对表【gen_table(代码生成业务表)】的数据库操作Mapper
 * @createDate 2023-03-28 09:38:00
 * @Entity generator.entity.GenTable
 */
@Mapper
public interface GenTableMapper extends BaseMapper<GenTable> {

	/**
	 * 查询数据库元数据
	 * @param page
	 * @param genTable
	 * @return
	 */
	Page<GenTable> selectTablePage(@Param("page") IPage<GenTable> page, @Param("genTable") GenTable genTable);

}
