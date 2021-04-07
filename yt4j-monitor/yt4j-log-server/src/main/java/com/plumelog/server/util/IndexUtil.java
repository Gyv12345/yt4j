/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.plumelog.server.util;

import com.plumelog.core.constant.LogMessageConstant;

import java.util.Date;

public class IndexUtil {

	public static String getRunLogIndex(Date date) {
		return LogMessageConstant.ES_INDEX + LogMessageConstant.LOG_TYPE_RUN + "_" + com.plumelog.server.util.DateUtil
				.parseDateToStr(date, com.plumelog.server.util.DateUtil.DATE_FORMAT_YYYYMMDD);
	}

	public static String getTraceLogIndex(Date date) {
		return LogMessageConstant.ES_INDEX + LogMessageConstant.LOG_TYPE_TRACE + "_" + com.plumelog.server.util.DateUtil
				.parseDateToStr(date, com.plumelog.server.util.DateUtil.DATE_FORMAT_YYYYMMDD);
	}

	public static String getRunLogIndex(Date date, String hour) {
		return LogMessageConstant.ES_INDEX + LogMessageConstant.LOG_TYPE_RUN + "_" + com.plumelog.server.util.DateUtil
				.parseDateToStr(date, com.plumelog.server.util.DateUtil.DATE_FORMAT_YYYYMMDD) + hour;
	}

	public static String getTraceLogIndex(Date date, String hour) {
		return LogMessageConstant.ES_INDEX + LogMessageConstant.LOG_TYPE_TRACE + "_" + com.plumelog.server.util.DateUtil
				.parseDateToStr(date, com.plumelog.server.util.DateUtil.DATE_FORMAT_YYYYMMDD) + hour;
	}

}
