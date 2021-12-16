/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.controller;

import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.sys.entity.SysDictItem;
import cn.yt4j.sys.service.SysDictItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (SysDictItem)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-09-10 10:29:08
 */
@Api(tags = "字典项")
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/item")
public class SysDictItemController {

	/**
	 * 服务对象
	 */
	private final SysDictItemService sysDictItemService;

	/**
	 * 分页查询所有数据
	 * @param sysDictItem 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("分页查询")
	@GetMapping
	public R<PageResult<SysDictItem>> selectAll(SysDictItem sysDictItem) {
		return R.ok(this.sysDictItemService.page(PageUtil.page(), new QueryWrapper<>(sysDictItem)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("获取单个")
	@GetMapping("{id}")
	public R selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysDictItemService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDictItem 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加")
	@PostMapping
	public R insert(@RequestBody SysDictItem sysDictItem) {
		return R.ok(this.sysDictItemService.save(sysDictItem));
	}

	@ApiOperation("批量添加")
	@PostMapping("batch/insert")
	public R<Boolean> batchInsert(@RequestBody List<SysDictItem> list) {
		return R.ok(this.sysDictItemService.saveBatch(list));
	}

	/**
	 * 修改数据
	 * @param sysDictItem 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改")
	@PutMapping
	public R update(@RequestBody SysDictItem sysDictItem) {
		return R.ok(this.sysDictItemService.updateById(sysDictItem));
	}

	/**
	 * 删除数据
	 * @param id 主键
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysDictItemService.removeById(id));
	}

}
