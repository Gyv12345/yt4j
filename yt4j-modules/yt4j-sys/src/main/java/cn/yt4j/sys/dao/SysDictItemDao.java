/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.dao;

import cn.yt4j.data.batch.Yt4jBatchMapper;
import cn.yt4j.sys.entity.SysDictItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysDictItemDao extends Yt4jBatchMapper<SysDictItem> {

	/**
	 * 批量添加
	 * @param items
	 * @return
	 */
	int batchInsert(@Param("items") List<SysDictItem> items);

}
