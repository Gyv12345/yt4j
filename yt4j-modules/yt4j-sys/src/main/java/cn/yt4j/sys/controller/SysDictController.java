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
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.entity.SysDict;
import cn.yt4j.sys.entity.vo.DictVO;
import cn.yt4j.sys.service.SysDictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典(SysDict)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:32
 */
@Api(tags = " 字典")
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict")
public class SysDictController {

	/**
	 * 服务对象
	 */
	private final SysDictService sysDictService;

	@SysLog("获取远程字典")
	@ApiOperation("远程字典")
	@GetMapping("remote/{code}")
	public R<List<DictVO>> listByCode(@PathVariable String code) {
		return R.ok(this.sysDictService.listByCode(code).stream().map(sysDictItem -> {
			DictVO vo = new DictVO();
			vo.setLabel(sysDictItem.getLabel());
			vo.setValue(sysDictItem.getValue());
			return vo;
		}).collect(Collectors.toList()));
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
	public R<SysDict> selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysDictService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDict 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加")
	@PostMapping("insert")
	public R insert(@RequestBody SysDict sysDict) {
		return R.ok(this.sysDictService.insert(sysDict));
	}

	/**
	 * 修改数据
	 * @param sysDict 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改")
	@PutMapping("update")
	public R update(@RequestBody SysDict sysDict) {
		return R.ok(this.sysDictService.update(sysDict));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysDictService.removeById(id));
	}

}
