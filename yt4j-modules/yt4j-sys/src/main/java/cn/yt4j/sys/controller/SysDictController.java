package cn.yt4j.sys.controller;

import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.sys.entity.SysDict;
import cn.yt4j.sys.entity.SysDictItem;
import cn.yt4j.sys.service.SysDictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 字典(SysDict)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:32
 */
@Api(tags = " 字典")
@AllArgsConstructor
@RestController
@RequestMapping("sys/dict")
public class SysDictController {

	/**
	 * 服务对象
	 */
	private final SysDictService sysDictService;

	@ApiOperation("远程字典")
	@GetMapping("remote/{code}")
	public R<List<SysDictItem>> listByCode(@PathVariable String code) {
		return R.ok(this.sysDictService.listByCode(code));
	}

	/**
	 * 分页查询所有数据
	 * @param sysDict 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("分页查询")
	@GetMapping
	public R<PageResult<SysDict>> selectAll(SysDict sysDict) {
		return R.ok(this.sysDictService.page(PageUtil.page(), new QueryWrapper<>(sysDict)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("获取单个")
	@GetMapping("{id}")
	public R selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysDictService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDict 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加")
	@PostMapping
	public R insert(@RequestBody SysDict sysDict) {
		return R.ok(this.sysDictService.save(sysDict));
	}

	/**
	 * 修改数据
	 * @param sysDict 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改")
	@PutMapping
	public R update(@RequestBody SysDict sysDict) {
		return R.ok(this.sysDictService.updateById(sysDict));
	}

	/**
	 * 删除数据
	 * @param idList 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping
	public R delete(@RequestParam("idList") @RequestBody List<Long> idList) {
		return R.ok(this.sysDictService.removeByIds(idList));
	}

}