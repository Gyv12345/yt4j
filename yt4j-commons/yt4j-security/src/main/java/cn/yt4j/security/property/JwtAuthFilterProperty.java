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
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Component
@Data
@ConfigurationProperties(prefix = "yt4j.jwt.filter")
public class JwtAuthFilterProperty {

	/**
	 * request header key
	 */
	private String header = HttpHeaders.AUTHORIZATION;

	/**
	 * request header value start
	 */
	private String tokenHead = "Bearer ";

	/**
	 * exclude url
	 */
	private List<String> ignoredUrl = new ArrayList<>();

}
