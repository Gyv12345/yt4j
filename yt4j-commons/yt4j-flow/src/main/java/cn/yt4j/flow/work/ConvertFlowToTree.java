
package cn.yt4j.flow.work;

import java.util.ArrayList;
import java.util.List;

/**
 * 流程转换为树
 *
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
