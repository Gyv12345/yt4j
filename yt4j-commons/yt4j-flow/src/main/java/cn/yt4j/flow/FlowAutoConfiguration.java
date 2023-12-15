
package cn.yt4j.flow;

import cn.yt4j.flow.property.FlowEnvProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gyv12345@163.com
 */
@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = { "cn.yt4j.flow", "cn.hutool.extra.spring" })
public class FlowAutoConfiguration {

	private final FlowEnvProperty flowEnvProperty;

}
