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
