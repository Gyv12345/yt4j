package cn.yt4j.flow.util;

import cn.yt4j.flow.work.WorkContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author gyv12345@163.com
 */
public class ElUtil {

    private static final String ALIAS = "data";

    public static Boolean condition(WorkContext context, String expression) {
        ExpressionParser parser = new SpelExpressionParser();

        Expression ex =
                parser.parseExpression(expression);
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable(ALIAS, context.getData());
        return ex.getValue(ctx, Boolean.class);
    }
}
