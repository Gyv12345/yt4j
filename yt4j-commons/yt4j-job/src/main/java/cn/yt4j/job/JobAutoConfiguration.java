/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
