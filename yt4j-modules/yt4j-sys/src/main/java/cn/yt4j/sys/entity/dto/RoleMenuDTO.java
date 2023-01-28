/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Schema(description = "角色菜单")
@Data
public class RoleMenuDTO implements Serializable {

	private static final long serialVersionUID = 8163461364967823330L;

	@Schema(description = "角色ID")
	@NotNull
	private Long roleId;

	@Schema(description = "菜单ID")
	@NotNull
	private List<Long> menuIds;

}
