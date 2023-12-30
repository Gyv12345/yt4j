
package cn.yt4j.sys.mapper;

import cn.yt4j.data.batch.Yt4jBaseMapper;
import cn.yt4j.sys.api.entity.SysDictItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysDictItem)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-18 16:44:07
 */
@Mapper
public interface SysDictItemMapper extends Yt4jBaseMapper<SysDictItem> {

	/**
	 * 批量添加
	 * @param items 实体集合
	 * @return 结果
	 */
	int batchInsert(@Param("items") List<SysDictItem> items);

}
