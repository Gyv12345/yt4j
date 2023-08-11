package cn.yt4j.flowserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 流程连线(FlowLine)表实体类
 *
 * @author makejava
 * @since 2023-08-11 11:35:12
 */
@Data
@ToString
public class FlowLine implements Serializable {

	private static final long serialVersionUID = -11922974144558817L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 从节点ID
	 */
	private String from;

	/**
	 * 到节点ID
	 */
	private String to;

	/**
	 * 标签
	 */
	private String label;

	/**
	 * 表达式 条件 现在支持 SpEL
	 */
	private String condition;

	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createUserId;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新者
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Long updateUserId;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 流程ID
	 */
	private Long flowInfoId;

}
