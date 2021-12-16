/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
