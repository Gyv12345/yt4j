
package cn.yt4j.flow.work;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
public class FlowEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 3298691564980761310L;

	/**
	 * 流程ID
	 */
	private String id;

	/**
	 * 流程名称
	 */
	private String name;

	/**
	 * 流程节点列表
	 */
	private List<NodeEntity> nodeList;

	/**
	 * 流程连线列表
	 */
	private List<LineEntity> lineList;

}
