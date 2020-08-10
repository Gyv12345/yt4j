package cn.yt4j.sys.controller;


import cn.yt4j.core.domain.R;
import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


/**
 * 角色(SysRole)表控制层
 *
 * @author makejava
 * @since 2020-08-10 08:43:34
 */
@Api(tags = " 角色")
@AllArgsConstructor
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    private final SysRoleService sysRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysRole 查询实体
     * @return 所有数据
     */
    @ApiOperation("分页查询")
    @GetMapping
    public R<Page<SysRole>> selectAll(Page<SysRole> page, SysRole sysRole) {
        return R.ok(this.sysRoleService.page(page, new QueryWrapper<>(sysRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("获取单个")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.sysRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRole 实体对象
     * @return 新增结果
     */
    @ApiOperation("添加")
    @PostMapping
    public R insert(@RequestBody SysRole sysRole) {
        return R.ok(this.sysRoleService.save(sysRole));
    }

    /**
     * 修改数据
     *
     * @param sysRole 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改")
    @PutMapping
    public R update(@RequestBody SysRole sysRole) {
        return R.ok(this.sysRoleService.updateById(sysRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation("删除")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.sysRoleService.removeByIds(idList));
    }
}