package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 前端路由
 *
 * @author gyv12345@163.com
 */
@Data
public class Route implements Serializable {

	private static final long serialVersionUID = 4000715486515628336L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 父级
	 */
	private Long parentId;

	/**
	 * 是否显示在左侧
	 */
	private Boolean hidden;

	/**
	 * 重定向
	 */
	private String redirect;

	/**
	 * 路由名称 不能重复
	 */
	private String name;

	/**
	 * 元数据
	 */
	private Meta meta;

	private Boolean hideChildrenInMenu;

}
