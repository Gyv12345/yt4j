package cn.yt4j.generate.controller;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.generate.entity.GenTable;
import cn.yt4j.generate.service.GenTableService;
import cn.yt4j.log.annotation.SysLog;
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
	@SysLog("分页查询数据源表")
	@PostMapping("page")
	public Result<PageResult<GenTable>> listPage(@Valid @RequestBody PageRequest<GenTable> request) {
		return Result.ok(this.genTableService.selectTablePage(request.page(), request.getData()));
	}

	/**
	 * 导入某个数据源某张表
	 * @param genTable 表信息
	 * @return 结果
	 */
	@SysLog("导入某张表")
	@PostMapping("page")
	public Result<Void> importTable(@RequestBody GenTable genTable) {

		return Result.ok();
	}

}
