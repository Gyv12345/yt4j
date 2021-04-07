/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.core.util;

import cn.hutool.core.date.DatePattern;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 这个是给easyexcel使用的
 *
 * @author gyv12345@163.com
 */
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

	@Override
	public Class<LocalDateTime> supportJavaTypeKey() {
		return LocalDateTime.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) {
		return LocalDateTime.parse(cellData.getStringValue(),
				DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN));
	}

	@Override
	public CellData<String> convertToExcelData(LocalDateTime value, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) {
		return new CellData<>(value.format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)));
	}

}
