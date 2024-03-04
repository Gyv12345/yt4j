package cn.yt4j.sys.controller.sys;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.entity.SysDeptUser;
import cn.yt4j.sys.service.SysDeptUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 部门用户(SysDeptUser)表控制层
 *
 * @author makejava
 * @since 2024-03-04 10:04:41
 */
@Tag(name = "部门用户")
@RequiredArgsConstructor
@RestController
@RequestMapping("sysDeptUser")
public class SysDeptUserController {
    /**
     * 服务对象
     */
    private final SysDeptUserService sysDeptUserService;

    /**
     * 分页查询所有数据
     *
     * @param request 查询实体
     * @return 所有数据
     */
    @SysLog("分页查询部门用户所有数据")
    @PostMapping("page")
    public Result<PageResult<SysDeptUser>> listPage(@Valid @RequestBody PageRequest<SysDeptUser> request) {
        return Result.ok(this.sysDeptUserService.page(request.page(), request.wrapper()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SysLog("通过主键查询部门用户单条数据")
    @GetMapping("get/{id}")
    public Result<SysDeptUser> selectOne(@PathVariable Long id) {
        return Result.ok(this.sysDeptUserService.getById(id));
    }

    /**
     * 新增部门用户数据
     *
     * @param sysDeptUser 实体对象
     * @return 新增结果
     */
    @SysLog("新增客户表数据")
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysDeptUser sysDeptUser) {
        return Result.ok(this.sysDeptUserService.save(sysDeptUser));
    }

    /**
     * 修改部门用户数据
     *
     * @param sysDeptUser 实体对象
     * @return 修改结果
     */
    @SysLog("修改部门用户数据")
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody SysDeptUser sysDeptUser) {
        return Result.ok(this.sysDeptUserService.updateById(sysDeptUser));
    }

    /**
     * 删除部门用户数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @SysLog("删除部门用户数据")
    @DeleteMapping("delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.ok(this.sysDeptUserService.removeById(id));
    }

}

