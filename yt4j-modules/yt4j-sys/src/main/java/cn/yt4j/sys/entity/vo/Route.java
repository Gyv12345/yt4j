/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
	 * 组件
	 */
	private String component;

	private String path;

	/**
	 * 元数据
	 */
	private Meta meta;

	private Boolean hideChildrenInMenu;

}
