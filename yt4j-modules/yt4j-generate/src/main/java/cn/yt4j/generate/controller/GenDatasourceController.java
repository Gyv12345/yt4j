package cn.yt4j.generate.controller;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.generate.entity.GenDatasource;
import cn.yt4j.generate.service.GenDatasourceService;
import cn.yt4j.log.annotation.SysLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 数据源相关
 *
 * @author gyv12345@163.com
 */
@Tag(name = "数据源")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/gen/datasource")
public class GenDatasourceController {

	private final GenDatasourceService genDatasourceService;

	/**
	 * 分页查询数据源
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@SysLog("分页查询数据源")
	@PostMapping("page")
	public R<PageResult<GenDatasource>> listPage(@Valid @RequestBody PageRequest<GenDatasource> request) {
		return R.ok(this.genDatasourceService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@SysLog("通过主键查询客户表单条数据")
	@GetMapping("get/{id}")
	public R<GenDatasource> selectOne(@PathVariable Serializable id) {
		return R.ok(this.genDatasourceService.getById(id));
	}

	/**
	 * 新增数据源表数据
	 * @param datasource 实体对象
	 * @return 新增结果
	 */
	@SysLog("新增数据源表数据")
	@PostMapping("insert")
	public R insert(@RequestBody GenDatasource datasource) {
		this.genDatasourceService.addOrUpdate(datasource);
		return R.ok();
	}

	/**
	 * 修改数据源表数据
	 * @param datasource 实体对象
	 * @return 修改结果
	 */
	@SysLog("修改数据源表数据")
	@PutMapping("update")
	public R update(@RequestBody GenDatasource datasource) {
		this.genDatasourceService.addOrUpdate(datasource);
		return R.ok();
	}

	/**
	 * 删除数据源表数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@SysLog("删除数据源表数据")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.genDatasourceService.removeById(id));
	}

	/**
	 * 获取数据源下拉
	 * @return
	 */
	@SysLog("获取数据源下拉")
	@GetMapping("dropDown")
	public R<List<GenDatasource>> dropDown() {
		return R.ok(this.genDatasourceService.list());
	}

}
