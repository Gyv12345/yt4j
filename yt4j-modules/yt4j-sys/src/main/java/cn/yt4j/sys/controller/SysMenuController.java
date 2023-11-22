
package cn.yt4j.sys.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysMenu;
import cn.yt4j.sys.entity.vo.MenuTreeVO;
import cn.yt4j.sys.entity.vo.Route;
import cn.yt4j.sys.entity.vo.TopMenuVO;
import cn.yt4j.sys.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "资源权限")
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
	public Result<List<Route>> nav(@PathVariable("id") Long applicationId) {
		return Result.ok(this.sysMenuService.nav(StpUtil.getLoginIdAsLong(), applicationId));
	}

	/**
	 * 获取顶部菜单
	 * @return
	 */
	@GetMapping("top")
	public Result<List<TopMenuVO>> topMenu() {
		return Result.ok(this.sysMenuService.topMenu());
	}

	/**
	 * 获取菜单树
	 * @return
	 */
	@GetMapping("tree")
	public Result<List<MenuTreeVO>> menuTree() {
		return Result.ok(this.sysMenuService.menuTree());
	}

	/**
	 * 分页查询所有数据
	 * @param sysMenu 查询实体
	 * @return 所有数据
	 */
	@GetMapping("list")
	public Result<PageResult<SysMenu>> selectAll(SysMenu sysMenu) {
		return Result.ok(this.sysMenuService.page(PageUtil.page(), new QueryWrapper<>(sysMenu)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("{id}")
	public Result<SysMenu> selectOne(@PathVariable Serializable id) {
		return Result.ok(this.sysMenuService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysMenu 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public Result insert(@RequestBody SysMenu sysMenu) {
		return Result.ok(this.sysMenuService.save(sysMenu));
	}

	/**
	 * 修改数据
	 * @param sysMenu 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public Result update(@RequestBody SysMenu sysMenu) {
		return Result.ok(this.sysMenuService.updateById(sysMenu));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable Long id) {
		return Result.ok(this.sysMenuService.removeById(id));
	}

	/**
	 * 根据用户Id查询用户权限列表
	 * @param userId
	 * @return
	 */
	@SysLog("根据用户Id查询用户权限列表")
	@GetMapping("/auth/list")
	public Result<List<String>> listByUserId(@RequestParam Long userId) {
		return Result.ok(this.sysMenuService.listByUserId(userId));
	}

}
