package cn.yt4j.sys.controller.common;

import cn.yt4j.core.domain.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gyv12345@163.com
 */
@Tag(name = "文件操作")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/common/file")
public class FileController {

    private final FileStorageService fileStorageService;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public Result<FileInfo> upload(MultipartFile file) {
        return Result.ok(fileStorageService.of(file).upload());
    }

}
