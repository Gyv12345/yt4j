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
 * 流程信息(FlowInfo)表实体类
 *
 * @author makejava
 * @since 2023-08-11 11:26:41
 */
@Data
@ToString
public class FlowInfo implements Serializable {

	private static final long serialVersionUID = -61131714042296499L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 流程名称
	 */
	private String flowName;

	/**
	 * 描述
	 */
	private String description;

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

}
