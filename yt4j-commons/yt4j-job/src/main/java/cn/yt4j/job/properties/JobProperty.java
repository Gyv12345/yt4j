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
