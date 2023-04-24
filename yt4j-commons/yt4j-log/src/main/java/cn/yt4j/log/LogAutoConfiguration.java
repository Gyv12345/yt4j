
package cn.yt4j.log;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.annotation.Order;

/**
 * 记录传递参数，返回结果，方便后期查询 使用Plumelog方便从es进行筛选 想着只需要写入日志文件，再使用elk这样的进行日志收集之后展示吧
 *
 * @author gyv12345@163.com
 */
@Order
@AutoConfiguration
@RequiredArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

}
