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
