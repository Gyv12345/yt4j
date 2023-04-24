
package cn.yt4j.sys.dao;

import cn.yt4j.data.batch.Yt4jBaseMapper;
import cn.yt4j.sys.api.entity.SysDictItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysDictItem)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-18 16:44:07
 */
@Mapper
public interface SysDictItemDao extends Yt4jBaseMapper<SysDictItem> {

	/**
	 * 批量添加
	 * @param items
	 * @return
	 */
	int batchInsert(@Param("items") List<SysDictItem> items);

}
