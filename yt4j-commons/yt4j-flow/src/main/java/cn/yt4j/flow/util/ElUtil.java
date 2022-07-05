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

import cn.hutool.extra.expression.ExpressionEngine;
import cn.hutool.extra.expression.engine.spel.SpELEngine;
import lombok.extern.slf4j.Slf4j;

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
		final Object flag = ENGINE.eval(expression, context);
		return (Boolean) flag;
	}

}
