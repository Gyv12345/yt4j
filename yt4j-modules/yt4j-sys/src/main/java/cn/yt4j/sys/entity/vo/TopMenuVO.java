/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 应用信息
 *
 * @author gyv12345@163.com
 */
@ApiModel(value = "应用", description = "")
@Data
public class TopMenuVO implements Serializable {

	private static final long serialVersionUID = 8628688151192898733L;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("Id")
	private Long id;

	@ApiModelProperty("路径")
	private String redirect;

}
