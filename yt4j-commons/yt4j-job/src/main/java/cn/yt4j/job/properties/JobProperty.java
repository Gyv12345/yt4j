/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.job.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gyv12345@163.com
 */
@Data
@ConfigurationProperties(prefix = "yt4j.job")
public class JobProperty {

	/**
	 * regAddresses
	 */
	private String adminAddresses;

	/**
	 *
	 */
	private String address;

	/**
	 * the app name
	 */
	private String appName;

	/**
	 * client ip
	 */
	private String ip;

	/**
	 * client rpc port
	 */
	private int port;

	/**
	 * the client access token
	 */
	private String accessToken;

	/**
	 * print log path
	 */
	private String logPath;

	/**
	 *
	 */
	private int logRetentionDays;

	/**
	 * enabled
	 */
	private boolean enabled = true;

}
