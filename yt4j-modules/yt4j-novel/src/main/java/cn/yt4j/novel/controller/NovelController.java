package cn.yt4j.novel.controller;

import cn.yt4j.novel.domain.Novel;
import cn.yt4j.novel.repository.NovelRepository;
import cn.yt4j.novel.service.NovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author gyv12
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("novel")
public class NovelController {

    private final NovelService novelService;

    private final NovelRepository novelRepository;

    @GetMapping("list2")
    public Object list2(String query){
        return this.novelRepository.queryNovelsByContent(query);
    }

    @GetMapping("list")
    public Object list(String query){
        return novelService.query(query);
    }

    @PostMapping("novel")
    public void save(@RequestBody Novel novel){
        this.novelService.save(novel);
    }

}
