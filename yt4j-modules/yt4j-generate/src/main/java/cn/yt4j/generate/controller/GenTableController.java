package cn.yt4j.generate.controller;

import cn.yt4j.generate.service.GenTableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyv12345@163.com
 */
@Tag(name = "查询数据库表")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/gen/table")
public class GenTableController {

	private final GenTableService genTableService;

}
