
package cn.yt4j.job;

import cn.yt4j.job.properties.JobProperty;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@AutoConfiguration
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
