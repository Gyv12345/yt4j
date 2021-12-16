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
