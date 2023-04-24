package cn.yt4j.generate.controller;

import cn.yt4j.core.domain.R;
import cn.yt4j.generate.entity.dto.QueryTablesDatasourceDTO;
import cn.yt4j.generate.service.GenTableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	 * 根据数据源名称查询数据库表信息
	 * @param dto
	 * @return
	 */
	@GetMapping("query/tables")
	public R queryTables(@RequestBody QueryTablesDatasourceDTO dto) {
		genTableService.queryTables(dto.getDatasourceName());
		return R.ok();
	}

}
