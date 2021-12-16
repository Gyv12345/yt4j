/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
