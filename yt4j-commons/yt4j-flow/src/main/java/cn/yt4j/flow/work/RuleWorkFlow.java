/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.flow.work;

import cn.yt4j.flow.util.ElUtil;
import cn.yt4j.flow.util.SpringContextHolder;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
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
