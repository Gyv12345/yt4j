package cn.yt4j.sys.controller.common;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.web.bind.annotation.PostMapping;
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

	private final FileStorageService fileStorageService;

	/**
	 * 直接读取 HttpServletRequest 中的文件进行上传，成功返回文件信息
	 */
	@PostMapping("/upload-request")
	public FileInfo uploadRequest(HttpServletRequest request) {
		return fileStorageService.of(request).upload();
	}

}
