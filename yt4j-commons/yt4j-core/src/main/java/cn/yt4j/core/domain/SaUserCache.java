
package cn.yt4j.core.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class SaUserCache implements Serializable {

	private static final long serialVersionUID = -592825050848857275L;

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
