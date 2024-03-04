package cn.yt4j.plugin.common.entity;

import lombok.Data;

/**
 * 基本部门
 *
 * @author gyv12345@163.com
 */
@Data
public class BaseDept {

	/**
	 * 部门名称
	 */
	private String name;

	/**
	 * 部门ID
	 */
	private String deptId;

	/**
	 * 部门排序
	 */
	private String order;

}
