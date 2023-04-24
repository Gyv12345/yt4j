
package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
public class Permissions implements Serializable {

	private static final long serialVersionUID = -8213313529146703872L;

	private String roleId;

	private String permissionId;

	private String permissionName;

	private String actions;

	private List<ActionEntitySet> actionEntitySet;

	private String actionList;

	private String dataAccess;

}
