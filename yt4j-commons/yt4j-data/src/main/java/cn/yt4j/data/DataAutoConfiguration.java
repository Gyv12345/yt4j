/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.data;

import cn.yt4j.data.batch.Yt4jLogicSqlInjector;
import cn.yt4j.data.interceptor.DataScopeInterceptor;
import cn.yt4j.data.interceptor.PreviewInterceptor;
import cn.yt4j.data.scope.DataScopeHandler;
import cn.yt4j.data.scope.DefaultDataScopeHandler;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * mybatis-plus配置 如果需要多租户、数据权限 直接进行扩展就好了
 *
 * @author gyv12345@163.com
 */
@ComponentScan("cn.yt4j.data")
@AutoConfiguration
public class DataAutoConfiguration {

	/**
	 * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false
	 * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		// 增加预览过滤器，增删改操作直接不成功
		interceptor.addInnerInterceptor(new PreviewInterceptor(true));
		// 增加数据权限处理器 ，现在使用的默认的，可以自己扩展
		interceptor.addInnerInterceptor(new DataScopeInterceptor(dataScopeHandler()));
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		return interceptor;
	}

	@Bean
	public Yt4jLogicSqlInjector injector() {
		return new Yt4jLogicSqlInjector();
	}

	public DataScopeHandler dataScopeHandler(){
		return new DefaultDataScopeHandler();
	}

}
