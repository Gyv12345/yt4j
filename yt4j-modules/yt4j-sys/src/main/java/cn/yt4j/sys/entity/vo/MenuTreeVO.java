/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.entity.vo;

import cn.yt4j.core.domain.BaseTree;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
public class MenuTreeVO extends BaseTree {

	private static final long serialVersionUID = 7541326659328732790L;

	@ApiModelProperty(value = "菜单标题")
	private String title;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "排序")
	private Integer orderNo;

	@ApiModelProperty(value = "路径")
	private String path;

	@ApiModelProperty(value = "组件路径")
	private String component;

	public MenuTreeVO() {
	}

	public MenuTreeVO(Long id, Long parentId, String name, List<BaseTree> children, String title, String icon,
			Integer orderNo, String path, String component) {
		super(id, parentId, name, children);
		this.title = title;
		this.icon = icon;
		this.orderNo = orderNo;
		this.path = path;
		this.component = component;
	}

	public MenuTreeVO(Long id, Long parentId, String name, String title, String icon, Integer orderNo, String path,
			String component) {
		super(id, parentId, name);
		this.title = title;
		this.icon = icon;
		this.orderNo = orderNo;
		this.path = path;
		this.component = component;
	}

}
