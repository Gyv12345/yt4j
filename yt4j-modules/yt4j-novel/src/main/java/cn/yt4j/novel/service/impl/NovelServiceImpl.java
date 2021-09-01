package cn.yt4j.novel.service.impl;

import cn.yt4j.novel.domain.Novel;
import cn.yt4j.novel.repository.NovelRepository;
import cn.yt4j.novel.service.NovelService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author gyv12
 */
@RequiredArgsConstructor
@Service
public class NovelServiceImpl implements NovelService {

    private final NovelRepository novelRepository;

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Override
    public void save(Novel novel) {
        novel.setId(UUID.randomUUID().toString());
        this.novelRepository.save(novel);
    }

    @Override
    public Object query(String query) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder
                // 整体匹配
//                .withQuery(QueryBuilders.termQuery("sex", param.getSex()))
                // 分词匹配
                .withQuery(QueryBuilders.matchQuery("content",query))
                .build();
        SearchHits<Novel> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Novel.class);
        return searchHits.get().collect(Collectors.toList());
    }
}
