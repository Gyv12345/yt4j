
package cn.yt4j.sys.entity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 角色菜单
 *
 * @author gyv12345@163.com
 */
@Data
@ToString
public class RoleMenuDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 8163461364967823330L;

	/**
	 * 角色ID
	 */
	@NotNull
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@NotNull
	private List<Long> menuIds;

}
