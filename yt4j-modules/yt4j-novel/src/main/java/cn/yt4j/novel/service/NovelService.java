package cn.yt4j.novel.service;

import cn.yt4j.novel.domain.Novel;

import java.util.List;

/**
 * @author gyv12
 */
public interface NovelService {

    void save(Novel novel);

    Object query(String query);
}
