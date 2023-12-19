package cn.yt4j.sys.controller.common;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyv12345@163.com
 */
@Tag(name = "文件操作")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/common/file")
public class FileController {

}
