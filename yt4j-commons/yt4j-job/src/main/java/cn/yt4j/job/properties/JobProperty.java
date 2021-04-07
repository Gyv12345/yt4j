/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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
    private boolean enabled=true;
}
