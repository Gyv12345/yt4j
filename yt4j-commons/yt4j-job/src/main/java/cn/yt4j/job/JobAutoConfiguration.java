/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.job;

import cn.yt4j.job.properties.JobProperty;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@Configuration
@EnableAutoConfiguration
public class JobAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JobProperty jobProperty() {
        return new JobProperty();
    }

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(jobProperty().getAdminAddresses());
        xxlJobSpringExecutor.setAddress(jobProperty().getAddress());
        xxlJobSpringExecutor.setAppname(jobProperty().getAppName());
        xxlJobSpringExecutor.setIp(jobProperty().getIp());
        xxlJobSpringExecutor.setPort(jobProperty().getPort());
        xxlJobSpringExecutor.setAccessToken(jobProperty().getAccessToken());
        xxlJobSpringExecutor.setLogPath(jobProperty().getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(jobProperty().getLogRetentionDays());

        return xxlJobSpringExecutor;
    }
}
