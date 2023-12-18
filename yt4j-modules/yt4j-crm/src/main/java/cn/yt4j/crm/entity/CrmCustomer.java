package cn.yt4j.crm.entity;

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
 * 客户表(CrmCustomer)表实体类
 *
 * @author gyv12345@163.com
 * @since 2023-11-30 14:55:41
 */
@Data
@ToString
public class CrmCustomer implements Serializable {

	@Serial
	private static final long serialVersionUID = 880156437610019045L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 客户名称
	 */
	private String customerName;

	/**
	 * 联系方式
	 */
	private String phone;

	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createUserId;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改人
	 */
	@TableField(fill = FieldFill.UPDATE)
	private Long updateUserId;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 部门
	 */
	private Long deptId;

}
