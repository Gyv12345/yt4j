package cn.yt4j.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class IpRegionConfig {

    @Bean
    public Searcher ip() {
        String dbPath = "D:\\ip2region.xdb";

        // 1、从 dbPath 加载整个 xdb 到内存。
        byte[] cBuff = new byte[0];
        try {
            cBuff = Searcher.loadContentFromFile(dbPath);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        // 2、使用上述的 cBuff 创建一个完全基于内存的查询对象。
        Searcher searcher = null;
        try {
            searcher = Searcher.newWithBuffer(cBuff);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return searcher;
    }
}
