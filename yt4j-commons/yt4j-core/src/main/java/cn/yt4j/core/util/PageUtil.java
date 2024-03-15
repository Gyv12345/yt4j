
package cn.yt4j.core.util;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 这样不是很灵活，前端需要将查询条件每次都要一一对照，不如使用post，更复杂的结构
 *
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
