package cn.yt4j.crm.entity.dto;

import cn.yt4j.crm.entity.CrmCustomer;
import io.github.linpeilie.annotations.AutoMapper;
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
@AutoMapper(target = CrmCustomer.class, reverseConvertGenerate = false)
public class CrmCustomerDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 845789675386295989L;

	/**
	 * 主键
	 */
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
	private Long createUserId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改人
	 */
	private Long updateUserId;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 部门
	 */
	private Long deptId;

}
