/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
