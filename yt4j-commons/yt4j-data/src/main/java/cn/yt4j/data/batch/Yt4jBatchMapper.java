/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.data.batch;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
public interface Yt4jBatchMapper<T> extends BaseMapper<T> {

	/**
	 * 不同数据库批量插入方式肯定是不同的 批量插入
	 * @param batchList
	 * @return
	 */
	int batchInsertByMysql(@Param("list") List<T> batchList);

}
