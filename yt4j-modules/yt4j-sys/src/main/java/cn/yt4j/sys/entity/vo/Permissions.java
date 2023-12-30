
package cn.yt4j.sys.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class Permissions implements Serializable {

	@Serial
	private static final long serialVersionUID = -8213313529146703872L;

	/**
	 * 角色ID
	 */
	private String roleId;

	/**
	 * 权限ID
	 */
	private String permissionId;

	/**
	 * 权限名称
	 */
	private String permissionName;

	/**
	 * 权限动作
	 */
	private String actions;

	private List<ActionEntitySet> actionEntitySet;

	private String actionList;

	private String dataAccess;

}
