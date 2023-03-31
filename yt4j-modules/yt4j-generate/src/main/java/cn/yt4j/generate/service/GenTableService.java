package cn.yt4j.generate.service;

import cn.yt4j.generate.entity.GenTable;
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
	 * 查询当前数据源表
	 * @param tableName
	 * @return
	 */
	List<Map<String, Object>> tables(String tableName);

}
