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
import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.entity.vo.DictVO;
import cn.yt4j.sys.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 角色(SysRole)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:34
 */
@Api(tags = " 角色")
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class SysRoleController {

	/**
	 * 服务对象
	 */
	private final SysRoleService sysRoleService;

	@ApiOperation("获取角色权限")
	@GetMapping("get/menus/{id}")
	public R<List<Long>> getMenuIds(@PathVariable Long id) {
		return R.ok(this.sysRoleService.listMenuIds(id));
	}

	@ApiOperation("角色下拉菜单")
	@GetMapping("select")
	public R<List<DictVO>> dropDown() {
		return R.ok(this.sysRoleService.dropDown());
	}

	@ApiOperation("设置权限")
	@PostMapping("setting")
	public R<Boolean> setting(@RequestBody RoleMenuDTO dto) {
		return R.ok(this.sysRoleService.setting(dto));
	}

	/**
	 * 分页查询所有数据
	 * @param sysRole 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("分页查询")
	@GetMapping("list")
	public R<PageResult<SysRole>> selectAll(SysRole sysRole) {
		return R.ok(this.sysRoleService.page(PageUtil.page(), new QueryWrapper<>(sysRole)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("获取单个")
	@GetMapping("get/{id}")
	public R<SysRole> selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysRoleService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysRole 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加")
	@PostMapping("insert")
	public R insert(@RequestBody SysRole sysRole) {
		return R.ok(this.sysRoleService.save(sysRole));
	}

	/**
	 * 修改数据
	 * @param sysRole 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改")
	@PutMapping("update")
	public R update(@RequestBody SysRole sysRole) {
		return R.ok(this.sysRoleService.updateById(sysRole));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysRoleService.removeById(id));
	}

}
