package cn.yt4j.flowserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 流程节点(FlowNode)表实体类
 *
 * @author gyv12345@163.com
 * @since 2023-08-11 11:35:14
 */
@Data
@ToString
public class FlowNode implements Serializable {

	@Serial
	private static final long serialVersionUID = -85055405057152978L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 节点名称
	 */
	private String name;

	/**
	 * 节点类型
	 */
	private String type;

	/**
	 * 距离左侧位置
	 */
	private String left;

	/**
	 * 距离上边位置
	 */
	private String top;

	/**
	 * 图标
	 */
	private String ico;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * bean名称
	 */
	private String beanId;

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

	/**
	 * 节点前端生成ID
	 */
	private String nodeId;

}
