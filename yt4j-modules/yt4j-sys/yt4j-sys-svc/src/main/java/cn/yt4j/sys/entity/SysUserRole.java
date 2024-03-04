
package cn.yt4j.sys.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * (SysUserRole)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:10
 */
@Data
public class SysUserRole implements Serializable {

	@Serial
	private static final long serialVersionUID = -6201247689742607651L;
	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 角色ID
	 */
	private Long roleId;

}
