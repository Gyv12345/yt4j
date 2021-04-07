package cn.yt4j.flow.work;

import lombok.Data;

/**
 * @author gyv12345@163.com
 */
@Data
public class NodeEntity {

	/**
	 * 节点ID
	 */
	private String id;

	/**
	 * 节点名称
	 */
	private String name;

	/**
	 * 实现的spring bean name
	 */
	private String beanId;

	/**
	 * 节点类型，为了后续规划，开始节点和结束节点，在我的设想里是必须存在的，以后还可以进行一些特殊处理
	 */
	private String type;

}
