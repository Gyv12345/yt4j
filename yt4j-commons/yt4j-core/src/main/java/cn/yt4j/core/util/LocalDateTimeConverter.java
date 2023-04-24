
package cn.yt4j.core.util;

import cn.hutool.core.date.DatePattern;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
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
	public LocalDateTime convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) throws Exception {
		return LocalDateTime.parse(cellData.getStringValue(),
				DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN));
	}

	@Override
	public WriteCellData<?> convertToExcelData(WriteConverterContext<LocalDateTime> context) throws Exception {
		return new WriteCellData<>(
				context.getValue().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)));
	}

}
