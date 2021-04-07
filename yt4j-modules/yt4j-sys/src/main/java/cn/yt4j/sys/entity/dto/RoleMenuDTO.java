/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@ApiModel(value = "设置角色菜单对象", description = "设置角色菜单")
public class RoleMenuDTO implements Serializable {

	private static final long serialVersionUID = 8163461364967823330L;

	@NotNull
	@ApiModelProperty(value = "角色ID")
	private Long roleId;

	@NotNull
	@ApiModelProperty(value = "菜单按钮")
	private List<Long> menuIds;

}
