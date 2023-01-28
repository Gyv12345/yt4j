/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.core.domain;

import cn.hutool.core.map.MapUtil;
import cn.yt4j.core.util.SearchUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class PageRequest<T> implements Serializable {

	private static final long serialVersionUID = -2788877367261112273L;

	/**
	 * 第几页
	 */
	private Long pageNo;

	/**
	 * 每页条数
	 */
	private Long pageSize;

	/**
	 * 查询条件
	 */
	private Map<String, Object> condition;

	public IPage<T> page() {
		Page<T> page = new Page<>(this.pageNo, this.pageSize);
		return page;
	}

	public Wrapper wrapper() {
		if (MapUtil.isEmpty(this.condition)) {
			return new QueryWrapper();
		}
		return SearchUtil.parseWhereSql(this.condition);
	}

}
