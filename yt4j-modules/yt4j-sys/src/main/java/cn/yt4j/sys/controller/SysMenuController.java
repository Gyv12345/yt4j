package cn.yt4j.sys.controller;


import cn.yt4j.core.domain.R;
import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


/**
 * 资源权限(SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-08-10 08:43:33
 */
@Api(tags = " 资源权限")
@AllArgsConstructor
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    private final SysMenuService sysMenuService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysMenu 查询实体
     * @return 所有数据
     */
    @ApiOperation("分页查询")
    @GetMapping
    public R<Page<SysMenu>> selectAll(Page<SysMenu> page, SysMenu sysMenu) {
        return R.ok(this.sysMenuService.page(page, new QueryWrapper<>(sysMenu)));
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
        return R.ok(this.sysMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实体对象
     * @return 新增结果
     */
    @ApiOperation("添加")
    @PostMapping
    public R insert(@RequestBody SysMenu sysMenu) {
        return R.ok(this.sysMenuService.save(sysMenu));
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改")
    @PutMapping
    public R update(@RequestBody SysMenu sysMenu) {
        return R.ok(this.sysMenuService.updateById(sysMenu));
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
        return R.ok(this.sysMenuService.removeByIds(idList));
    }
}