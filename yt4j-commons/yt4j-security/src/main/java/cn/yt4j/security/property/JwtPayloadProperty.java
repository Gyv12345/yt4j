/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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
