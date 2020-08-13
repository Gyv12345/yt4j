package cn.yt4j.sys.controller;

import cn.yt4j.core.domain.R;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * 用户(SysUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@Api(tags = "用户")
@AllArgsConstructor
@RestController
@RequestMapping("sysUser")
public class SysUserController {

	/**
	 * 服务对象
	 */
	private final SysUserService sysUserService;

	@ApiOperation("登录")
	@PostMapping("login")
	public R<String> login(@RequestBody @Valid UserDTO dto) {
		return R.ok(this.sysUserService.login(dto));
	}

	/**
	 * 分页查询所有数据
	 * @param page 分页对象
	 * @param sysUser 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("查询")
	@GetMapping("list")
	public R<Page<SysUser>> selectAll(Page<SysUser> page, SysUser sysUser) {
		return R.ok(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("查询")
	@GetMapping("get/{id}")
	public R selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysUserService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysUser 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public R insert(@RequestBody SysUser sysUser) {
		return R.ok(this.sysUserService.save(sysUser));
	}

	/**
	 * 修改数据
	 * @param sysUser 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public R update(@RequestBody SysUser sysUser) {
		return R.ok(this.sysUserService.updateById(sysUser));
	}

	/**
	 * 删除数据
	 * @param idList 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete")
	public R delete(@RequestParam("idList") List<Long> idList) {
		return R.ok(this.sysUserService.removeByIds(idList));
	}

}