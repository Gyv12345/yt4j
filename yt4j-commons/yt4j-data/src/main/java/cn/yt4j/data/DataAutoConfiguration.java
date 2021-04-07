/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.data;

import cn.yt4j.data.batch.Yt4jLogicSqlInjector;
import cn.yt4j.data.interceptor.PreviewInterceptor;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus配置 如果需要多租户、数据权限 直接进行扩展就好了
 *
 * @author gyv12345@163.com
 */
@ComponentScan("cn.yt4j.data")
@Configuration
public class DataAutoConfiguration {

	/**
	 * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false
	 * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		// 增加预览过滤器，增删改操作直接不成功
		interceptor.addInnerInterceptor(new PreviewInterceptor(true));
		return interceptor;
	}

	@Bean
	public Yt4jLogicSqlInjector injector() {
		return new Yt4jLogicSqlInjector();
	}

}
