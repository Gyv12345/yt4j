package cn.yt4j.generate.service;

import cn.yt4j.generate.entity.GenTable;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @author gyv12345@163.com
 * @description 针对表【gen_table(代码生成业务表)】的数据库操作Service
 * @createDate 2023-03-28 09:38:00
 */
public interface GenTableService extends IService<GenTable> {

	/**
	 * 分页查询数据源表
	 * @param page
	 * @param genTable
	 * @return
	 */
	Page<GenTable> selectTablePage(IPage<GenTable> page, GenTable genTable);

	/**
	 * 查询当前数据源表
	 * @param tableName
	 * @return
	 */
	List<Map<String, Object>> tables(String tableName);

	/**
	 * 导入表结构
	 * @param genTable
	 */
	void importTable(GenTable genTable);

}
