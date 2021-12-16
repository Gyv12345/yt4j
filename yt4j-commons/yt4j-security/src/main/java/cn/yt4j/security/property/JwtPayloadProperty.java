/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.security.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gyv12345@163.com
 */
@Component
@Data
@ConfigurationProperties(prefix = "yt4j.jwt.payload")
public class JwtPayloadProperty {

	/**
	 * user secret
	 */
	private String secret = "1cd58e58fb1fb97d9fc9faf2587b3254fb08d74b77e38231b4b5e18df8ee6ffc";

	/**
	 * issuer
	 */
	private String issuer = "yt4j.cn";

	/**
	 * audience
	 */
	private String audience = "vip";

	/**
	 * expirationMinute default 30 day
	 */
	private int expirationMinute = 30 * 24 * 60 * 60;

	/**
	 * NotBefore default 15 minute
	 */
	private int notBeforeMinute = 15;

}
