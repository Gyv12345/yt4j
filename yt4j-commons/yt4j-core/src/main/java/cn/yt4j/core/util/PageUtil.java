/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.core.util;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 做的多了，发现这样写还是有问题的，分页查询他们也是用post，基本上Post走遍天下，那这样写就有问题了
 * @author gyv12345@163.com
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
