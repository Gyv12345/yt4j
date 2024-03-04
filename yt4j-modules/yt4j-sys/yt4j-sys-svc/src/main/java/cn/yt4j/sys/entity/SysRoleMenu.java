
package cn.yt4j.sys.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 角色权限(SysRoleMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:09
 */
@Data
public class SysRoleMenu implements Serializable {

	@Serial
	private static final long serialVersionUID = -7796141701917016773L;
	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 菜单ID
	 */
	private Long menuId;

}
