/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.core.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class SaUserCache {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 登录名称
	 */
	private String username;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 所属部门ID
	 */
	private Long deptId;

	/**
	 * 角色列表
	 */
	private List<String> roles;

	/**
	 * 权限列表
	 */
	private List<String> permissions;

	/**
	 * 数据权限
	 */
	private Integer dataScope;

}
