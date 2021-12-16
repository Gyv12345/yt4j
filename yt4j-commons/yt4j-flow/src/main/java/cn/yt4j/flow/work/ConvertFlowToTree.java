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

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
public class ConvertFlowToTree {

	public static List<TreeFlow> build(FlowEntity entity) {
		List<TreeFlow> list = new ArrayList<>();
		entity.getNodeList().forEach(item -> {
			TreeFlow tree = new TreeFlow();
			tree.setId(item.getId());
			tree.setBeanId(item.getBeanId());
			tree.setName(item.getName());
			tree.setBeanId(item.getBeanId());
			tree.setParentId(entity.getId());
			for (LineEntity line : entity.getLineList()) {
				if (line.getTo().equals(item.getId())) {
					tree.setParentId(line.getFrom());
					tree.setCondition(line.getCondition());
				}
			}
			list.add(tree);
		});
		return list;
	}

}
