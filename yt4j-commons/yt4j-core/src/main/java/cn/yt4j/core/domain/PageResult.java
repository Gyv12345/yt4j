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

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 * @param <T>
 */
@Data
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = 983447747149487589L;

	/**
	 * 第几页
	 */
	private Long pageNo = 1L;

	/**
	 * 每页条数
	 */
	private Long pageSize = 10L;

	/**
	 * 总页数
	 */
	private Long totalPage = 0L;

	/**
	 * 总记录数
	 */
	private Long totalCount = 0L;

	/**
	 * 结果集
	 */
	private List<T> data;

	public PageResult() {
	}

	public PageResult(IPage<T> page) {
		this.setData(page.getRecords());
		this.setTotalCount(page.getTotal());
		this.setPageNo(page.getCurrent());
		this.setPageSize(page.getSize());
		this.setTotalPage(page.getPages());

	}

	public PageResult(IPage page, List<T> t) {
		this.setData(t);
		this.setTotalCount(page.getTotal());
		this.setPageNo(page.getCurrent());
		this.setPageSize(page.getSize());
		this.setTotalPage(page.getPages());

	}

}
