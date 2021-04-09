/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.flow.util;

import cn.yt4j.flow.work.WorkContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author gyv12345@163.com
 */
@Slf4j
public class ElUtil {

	private static final String ALIAS = "data";

	public static Boolean condition(WorkContext context, String expression) {
		log.info("条件：[{}]",expression);
		ExpressionParser parser = new SpelExpressionParser();

		Expression ex = parser.parseExpression(expression);
		EvaluationContext ctx = new StandardEvaluationContext();
		ctx.setVariable(ALIAS, context.getData());
		return ex.getValue(ctx, Boolean.class);
	}

}
