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
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysDept;
import cn.yt4j.sys.service.SysDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
	@SysLog("获取部门机构树")
	@GetMapping("tree")
	public R<List<BaseTree>> treeDept() {
		return R.ok(this.sysDeptService.treeDept());
	}

	/**
	 * 分页查询所有数据d
	 * @param sysDept 查询实体
	 * @return 所有数据
	 */
	@SysLog("部门分页查询")
	@GetMapping
	public R<PageResult<SysDept>> selectAll(SysDept sysDept) {
		return R.ok(this.sysDeptService.page(PageUtil.page(), new QueryWrapper<>(sysDept)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("get/{id}")
	public R<SysDept> selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysDeptService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDept 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public R insert(@RequestBody SysDept sysDept) {
		return R.ok(this.sysDeptService.save(sysDept));
	}

	/**
	 * 修改数据
	 * @param sysDept 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public R update(@RequestBody SysDept sysDept) {
		return R.ok(this.sysDeptService.updateById(sysDept));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysDeptService.removeById(id));
	}

}
