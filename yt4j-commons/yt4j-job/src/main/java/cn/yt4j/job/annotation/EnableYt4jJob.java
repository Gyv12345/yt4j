package cn.yt4j.job.annotation;

import cn.yt4j.job.JobAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author gyv12345@163.com
 */
@Order
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({JobAutoConfiguration.class})
public @interface EnableYt4jJob {
}
