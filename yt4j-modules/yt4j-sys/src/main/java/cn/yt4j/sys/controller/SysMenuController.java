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

import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysMenu;
import cn.yt4j.sys.entity.vo.MenuTreeVO;
import cn.yt4j.sys.entity.vo.Route;
import cn.yt4j.sys.entity.vo.TopMenuVO;
import cn.yt4j.sys.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 资源权限(SysMenu)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:33
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class SysMenuController {

	/**
	 * 服务对象
	 */
	private final SysMenuService sysMenuService;

	/**
	 * 通过应用ID获取菜单
	 * @param applicationId
	 * @return
	 */
	@GetMapping("nav/{id}")
	public R<List<Route>> nav(@PathVariable("id") Long applicationId) {
		return R.ok(this.sysMenuService.nav(StpUtil.getLoginIdAsLong(), applicationId));
	}

	/**
	 * @return
	 */
	@GetMapping("top")
	public R<List<TopMenuVO>> topMenu() {
		return R.ok(this.sysMenuService.topMenu());
	}

	@GetMapping("tree")
	public R<List<MenuTreeVO>> menuTree() {
		return R.ok(this.sysMenuService.menuTree());
	}

	/**
	 * 分页查询所有数据
	 * @param sysMenu 查询实体
	 * @return 所有数据
	 */
	@GetMapping("list")
	public R<PageResult<SysMenu>> selectAll(SysMenu sysMenu) {
		return R.ok(this.sysMenuService.page(PageUtil.page(), new QueryWrapper<>(sysMenu)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("{id}")
	public R<SysMenu> selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysMenuService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysMenu 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public R insert(@RequestBody SysMenu sysMenu) {
		return R.ok(this.sysMenuService.save(sysMenu));
	}

	/**
	 * 修改数据
	 * @param sysMenu 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public R update(@RequestBody SysMenu sysMenu) {
		return R.ok(this.sysMenuService.updateById(sysMenu));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysMenuService.removeById(id));
	}

	@SysLog("根据用户Id查询用户权限列表")
	@GetMapping("/auth/list")
	public R<List<String>> listByUserId(@RequestParam Long userId) {
		return R.ok(this.sysMenuService.listByUserId(userId));
	}

}
