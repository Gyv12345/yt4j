package cn.yt4j.generate.controller;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.generate.entity.GenTable;
import cn.yt4j.generate.service.GenTableService;
import cn.yt4j.log.annotation.SysLog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyv12345@163.com
 */
@Tag(name = "查询数据库表")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/table")
public class GenTableController {

	private final GenTableService genTableService;

	/**
	 * 分页查询数据源表
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@Operation(summary = "分页查询数据源表")
	@SysLog("分页查询数据源表")
	@PostMapping("page")
	public R<PageResult<GenTable>> listPage(@Valid @RequestBody PageRequest<GenTable> request) {
		return R.ok(this.genTableService.selectTablePage(request.page(), request.getData()));
	}

}
