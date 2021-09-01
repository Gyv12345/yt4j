package cn.yt4j.novel.repository;

import cn.yt4j.novel.domain.Novel;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author gyv12
 */
public interface NovelRepository extends ElasticsearchRepository<Novel,String> {
    /**
     * 查询
     * @param content
     * @return
     */
    List<Novel> queryNovelsByContent(String content);


}
