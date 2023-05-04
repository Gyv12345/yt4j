package cn.yt4j.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 代码生成业务表字段
 *
 * @author gyv12345@163.com
 * @TableName gen_table_column
 */
@TableName(value = "gen_table_column")
@Data
public class GenTableColumn implements Serializable {

	private static final long serialVersionUID = 4856624367120382987L;

	/**
	 * 编号
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long columnId;

	/**
	 * 归属表编号
	 */
	private Long tableId;

	/**
	 * 列名称
	 */
	private String columnName;

	/**
	 * 列描述
	 */
	private String columnComment;

	/**
	 * 列类型
	 */
	private String columnType;

	/**
	 * JAVA类型
	 */
	private String javaType;

	/**
	 * JAVA字段名
	 */
	private String javaField;

	/**
	 * 是否主键（1是）
	 */
	private String isPk;

	/**
	 * 是否自增（1是）
	 */
	private String isIncrement;

	/**
	 * 是否必填（1是）
	 */
	private String isRequired;

	/**
	 * 是否为插入字段（1是）
	 */
	private String isInsert;

	/**
	 * 是否编辑字段（1是）
	 */
	private String isEdit;

	/**
	 * 是否列表字段（1是）
	 */
	private String isList;

	/**
	 * 是否查询字段（1是）
	 */
	private String isQuery;

	/**
	 * 查询方式（等于、不等于、大于、小于、范围）
	 */
	private String queryType;

	/**
	 * 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）
	 */
	private String htmlType;

	/**
	 * 字典类型
	 */
	private String dictType;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
