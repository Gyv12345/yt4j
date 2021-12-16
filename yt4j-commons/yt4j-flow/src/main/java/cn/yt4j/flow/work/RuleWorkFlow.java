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

import cn.yt4j.flow.util.ElUtil;
import cn.yt4j.flow.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Slf4j
public class RuleWorkFlow extends AbstractWorkFlow {

	private String condition;

	public String getCondition() {
		return condition;
	}

	private String beanId;

	private final List<RuleWorkFlow> nextNodes = new ArrayList<>();

	public static RuleWorkFlowBuilder builder() {
		return new RuleWorkFlowBuilder();
	}

	public List<RuleWorkFlow> getNextNodes() {
		return nextNodes;
	}

	RuleWorkFlow(String name, String id, String beanId, String condition) {
		super(name, id);
		this.beanId = beanId;
		this.condition = condition;
	}

	@Override
	public int execute(WorkContext context) {
		int status = 0;
		log.info("执行节点：[{}]",this.getName());
		if (StringUtils.hasText(this.beanId)) {
			Work work = SpringContextHolder.getBean(this.beanId);
			status = work.execute(context);
		}
		for (RuleWorkFlow flow : nextNodes) {
			if (!StringUtils.hasText(flow.getCondition())) {
				status = flow.execute(context);
			}
			if (StringUtils.hasText(flow.getCondition()) && ElUtil.condition(context, flow.getCondition())) {
				status = flow.execute(context);
			}
		}
		if (EXIT == status) {
			return EXIT;
		}
		return NEXT;
	}

	public static class RuleWorkFlowBuilder {

		private String name;

		private String id;

		private String condition;

		private String beanId;

		RuleWorkFlowBuilder() {

		}

		public RuleWorkFlowBuilder name(String name) {
			this.name = name;
			return this;
		}

		public RuleWorkFlowBuilder id(String id) {
			this.id = id;
			return this;
		}

		public RuleWorkFlowBuilder condition(String condition) {
			this.condition = condition;
			return this;
		}

		public RuleWorkFlowBuilder beanId(String beanId) {
			this.beanId = beanId;
			return this;
		}

		public RuleWorkFlow build() {
			return new RuleWorkFlow(this.name, this.id, this.beanId, this.condition);
		}

	}

}
