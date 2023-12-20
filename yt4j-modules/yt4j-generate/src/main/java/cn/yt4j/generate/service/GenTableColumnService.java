package cn.yt4j.generate.service;

import cn.yt4j.generate.entity.GenTableColumn;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 代码生成业务表字段
 * @author gyv12345@163.com
 */
public interface GenTableColumnService extends IService<GenTableColumn> {

	/**
	 * 根据表名称
	 * @param tableName 表名称
	 * @return 结果
	 */
	List<GenTableColumn> selectDbTableColumnsByName(String tableName);

}
