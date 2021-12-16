/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
