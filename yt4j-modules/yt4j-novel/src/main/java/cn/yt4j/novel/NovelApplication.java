package cn.yt4j.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author gyv12
 */
@EnableElasticsearchRepositories
@SpringBootApplication
public class NovelApplication {
    public static void main(String[] args) {
        SpringApplication.run(NovelApplication.class,args);
    }
}
