package cn.yt4j.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 代码生成业务表
 *
 * @author gyv12345@163.com
 * @TableName gen_table
 */
@TableName(value = "gen_table")
@Data
public class GenTable implements Serializable {

	private static final long serialVersionUID = 3278187740949370191L;

	/**
	 * 编号
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@JsonSerialize(using = StringSerializer.class)
	private Long tableId;

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 表描述
	 */
	private String tableComment;

	/**
	 * 关联子表的表名
	 */
	private String subTableName;

	/**
	 * 子表关联的外键名
	 */
	private String subTableFkName;

	/**
	 * 实体类名称
	 */
	private String className;

	/**
	 * 使用的模板（crud单表操作 tree树表操作）
	 */
	private String tplCategory;

	/**
	 * 生成包路径
	 */
	private String packageName;

	/**
	 * 生成模块名
	 */
	private String moduleName;

	/**
	 * 生成业务名
	 */
	private String businessName;

	/**
	 * 生成功能名
	 */
	private String functionName;

	/**
	 * 生成功能作者
	 */
	private String functionAuthor;

	/**
	 * 生成代码方式（0zip压缩包 1自定义路径）
	 */
	private String genType;

	/**
	 * 生成路径（不填默认项目路径）
	 */
	private String genPath;

	/**
	 * 其它生成选项
	 */
	private String options;

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

	/**
	 * 备注
	 */
	private String remark;

}
