/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
