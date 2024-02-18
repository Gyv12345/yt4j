
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
public class Role implements Serializable {

	@Serial
	private static final long serialVersionUID = 8333219920882065467L;

	private String id;

	/**
	 *
	 */
	private String name;

	private String describe;

	private int status;

	private String creatorId;

	private int createTime;

	private int deleted;

	private List<Permissions> permissions;

}
