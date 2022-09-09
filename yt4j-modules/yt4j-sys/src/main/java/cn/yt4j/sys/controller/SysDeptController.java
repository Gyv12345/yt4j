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

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysDept;
import cn.yt4j.sys.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 部门(SysDept)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:51
 */
@Api(tags = "部门操作")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/dept")
public class SysDeptController {

	/**
	 * 服务对象
	 */
	private final SysDeptService sysDeptService;

	/**
	 * 机构树
	 * @return
	 */
	@ApiOperation("获取部门机构树")
	@SysLog("获取部门机构树")
	@GetMapping("tree")
	public R<List<BaseTree>> treeDept() {
		return R.ok(this.sysDeptService.treeDept());
	}

	@ApiOperation("部门分页查询")
	@SysLog("部门分页查询")
	@PostMapping("page")
	public R<PageResult<SysDept>> selectAll(@RequestBody PageRequest<SysDept> pageRequest) {
		return R.ok(this.sysDeptService.page(pageRequest.page(), pageRequest.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("通过主键查询单条数据")
	@GetMapping("get/{id}")
	public R<SysDept> selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysDeptService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDept 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("新增部门数据")
	@PostMapping("insert")
	public R insert(@RequestBody SysDept sysDept) {
		return R.ok(this.sysDeptService.save(sysDept));
	}

	/**
	 * 修改数据
	 * @param sysDept 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改部门数据")
	@PutMapping("update")
	public R update(@RequestBody SysDept sysDept) {
		return R.ok(this.sysDeptService.updateById(sysDept));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除部门数据")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysDeptService.removeById(id));
	}

}
