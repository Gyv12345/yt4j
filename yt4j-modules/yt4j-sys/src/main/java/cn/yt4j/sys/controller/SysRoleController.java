
package cn.yt4j.sys.controller;

import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysRole;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.entity.vo.DictVO;
import cn.yt4j.sys.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "角色")
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class SysRoleController {

	/**
	 * 服务对象
	 */
	private final SysRoleService sysRoleService;

	/**
	 * 根据角色ID获取菜单
	 * @param id 角色ID
	 * @return
	 */
	@GetMapping("get/menus/{id}")
	public Result<List<Long>> getMenuIds(@PathVariable Long id) {
		return Result.ok(this.sysRoleService.listMenuIds(id));
	}

	/**
	 * 角色下拉
	 * @return
	 */
	@GetMapping("select")
	public Result<List<DictVO>> dropDown() {
		return Result.ok(this.sysRoleService.dropDown());
	}

	/**
	 * 角色设置
	 * @param dto
	 * @return
	 */
	@PostMapping("setting")
	public Result<Boolean> setting(@RequestBody RoleMenuDTO dto) {
		return Result.ok(this.sysRoleService.setting(dto));
	}

	/**
	 * 分页查询所有数据
	 * @param sysRole 查询实体
	 * @return 所有数据
	 */
	@GetMapping("list")
	public Result<PageResult<SysRole>> selectAll(SysRole sysRole) {
		return Result.ok(this.sysRoleService.page(PageUtil.page(), new QueryWrapper<>(sysRole)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("get/{id}")
	public Result<SysRole> selectOne(@PathVariable Serializable id) {
		return Result.ok(this.sysRoleService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysRole 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public Result insert(@RequestBody SysRole sysRole) {
		return Result.ok(this.sysRoleService.save(sysRole));
	}

	/**
	 * 修改数据
	 * @param sysRole 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public Result update(@RequestBody SysRole sysRole) {
		return Result.ok(this.sysRoleService.updateById(sysRole));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable Long id) {
		return Result.ok(this.sysRoleService.removeById(id));
	}

	/**
	 * 根据用户Id查询用户角色列表
	 * @param userId
	 * @return
	 */
	@SysLog("根据用户Id查询用户角色列表")
	@GetMapping("/auth/list")
	public Result<List<String>> listByUserId(@RequestParam Long userId) {
		return Result.ok(this.sysRoleService.listByUserId(userId));
	}

}
