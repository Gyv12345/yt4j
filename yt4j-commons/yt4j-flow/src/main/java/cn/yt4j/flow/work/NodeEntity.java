/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
