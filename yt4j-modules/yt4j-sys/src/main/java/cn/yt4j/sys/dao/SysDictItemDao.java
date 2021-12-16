/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
