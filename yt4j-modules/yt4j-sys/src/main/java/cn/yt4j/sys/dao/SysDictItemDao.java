package cn.yt4j.sys.dao;

import cn.yt4j.sys.entity.SysDictItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysDictItem)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-18 16:44:07
 */
public interface SysDictItemDao extends BaseMapper<SysDictItem> {

	/**
	 * 批量添加
	 * @param items
	 * @return
	 */
	int batchInsert(@Param("items") List<SysDictItem> items);

}