package cn.yt4j.core.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12
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
	private Long pageSize = 20L;

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

	public PageResult(Page<T> page) {
		this.setData(page.getRecords());
		this.setTotalCount(page.getTotal());
		this.setPageNo(page.getCurrent());
		this.setPageSize(page.getSize());
		this.setTotalPage(page.getPages());

	}

	public PageResult(Page page, List<T> t) {
		this.setData(t);
		this.setTotalCount(page.getTotal());
		this.setPageNo(page.getCurrent());
		this.setPageSize(page.getSize());
		this.setTotalPage(page.getPages());

	}

}
