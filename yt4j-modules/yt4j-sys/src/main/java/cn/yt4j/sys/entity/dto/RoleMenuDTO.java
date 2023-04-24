
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
