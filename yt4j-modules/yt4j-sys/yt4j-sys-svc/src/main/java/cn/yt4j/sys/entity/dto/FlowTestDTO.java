
package cn.yt4j.sys.entity.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 流程实体
 *
 * @author gyv12345@163.com
 */
@Data
public class FlowTestDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -7678645335880668714L;

	/**
	 * 年龄
	 */
	private Integer age;

}
