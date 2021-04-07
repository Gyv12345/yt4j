/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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
