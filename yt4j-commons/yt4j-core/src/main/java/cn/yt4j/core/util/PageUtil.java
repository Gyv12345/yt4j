/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.core.util;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gyv123456@163.com
 */
public class PageUtil {

	private static final String PAGE_SIZE = "pageSize";

	private static final String PAGE_NO = "pageNo";

	public static <T> Page<T> page() {

		int pageSize = 10;
		int pageNo = 1;
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
				.getRequest();

		// 每页条数
		String pageSizeString = request.getParameter(PAGE_SIZE);
		if (ObjectUtil.isNotEmpty(pageSizeString)) {
			pageSize = Integer.parseInt(pageSizeString);
		}

		// 第几页
		String pageNoString = request.getParameter(PAGE_NO);
		if (ObjectUtil.isNotEmpty(pageNoString)) {
			pageNo = Integer.parseInt(pageNoString);
		}

		return new Page<>(pageNo, pageSize);
	}

}
