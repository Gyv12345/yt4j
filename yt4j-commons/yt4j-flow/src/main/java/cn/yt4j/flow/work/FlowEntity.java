package cn.yt4j.flow.work;

import lombok.Data;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
public class FlowEntity {

	private String id;

	private String name;

	private List<NodeEntity> nodeList;

	private List<LineEntity> lineList;

}
