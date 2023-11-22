
package cn.yt4j.flow.util;

import cn.hutool.extra.expression.ExpressionEngine;
import cn.hutool.extra.expression.engine.spel.SpELEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * spel表达式工具
 *
 * @author gyv12345@163.com
 */
@Slf4j
public class ElUtil {

	public final static ExpressionEngine ENGINE = new SpELEngine();

	public static Boolean condition(Map<String, Object> context, String expression) {
		log.info("条件：[{}]", expression);
		final Object flag = ENGINE.eval(expression, context, Collections.singleton(Object.class));
		return (Boolean) flag;
	}

}
