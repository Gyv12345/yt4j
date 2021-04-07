/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.data.interceptor;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;

import java.sql.SQLException;

/**
 * 预览过滤器
 *
 * @author gyv12345@163.com
 */
public class PreviewInterceptor implements InnerInterceptor {

	private Boolean preview;

	public PreviewInterceptor(Boolean preview) {
		this.preview = preview;
	}

	@Override
	public boolean willDoUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
		return this.preview;
	}

}
