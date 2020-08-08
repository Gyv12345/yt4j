package cn.yt4j.sys.controller;


import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-08-07 17:11:45
 */
@AllArgsConstructor
@RestController
@RequestMapping("sysUser")
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    private final SysUserService sysUserService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysUser> page, SysUser sysUser) {
        return success(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.save(sysUser));
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.updateById(sysUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserService.removeByIds(idList));
    }
}