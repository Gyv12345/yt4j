package cn.yt4j.crm.controller;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.crm.entity.CrmCustomer;
import cn.yt4j.crm.service.CrmCustomerService;
import cn.yt4j.log.annotation.SysLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 客户表(CrmCustomer)表控制层
 *
 * @author makejava
 * @since 2023-11-30 14:58:02
 */
@Tag(name = "客户表")
@RequiredArgsConstructor
@RestController
@RequestMapping("crmCustomer")
public class CrmCustomerController {
    /**
     * 服务对象
     */
    private final CrmCustomerService crmCustomerService;

    /**
     * 分页查询所有数据
     *
     * @param request 查询实体
     * @return 所有数据
     */
    @SysLog("分页查询客户表所有数据")
    @PostMapping("page")
    public Result<PageResult<CrmCustomer>> listPage(@Valid @RequestBody PageRequest<CrmCustomer> request) {
        return Result.ok(this.crmCustomerService.page(request.page(), request.wrapper()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SysLog("通过主键查询客户表单条数据")
    @GetMapping("get/{id}")
    public Result<CrmCustomer> selectOne(@PathVariable Long id) {
        return Result.ok(this.crmCustomerService.getById(id));
    }

    /**
     * 新增客户表数据
     *
     * @param crmCustomer 实体对象
     * @return 新增结果
     */
    @SysLog("新增客户表数据")
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody CrmCustomer crmCustomer) {
        return Result.ok(this.crmCustomerService.save(crmCustomer));
    }

    /**
     * 修改客户表数据
     *
     * @param crmCustomer 实体对象
     * @return 修改结果
     */
    @SysLog("修改客户表数据")
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody CrmCustomer crmCustomer) {
        return Result.ok(this.crmCustomerService.updateById(crmCustomer));
    }

    /**
     * 删除客户表数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @SysLog("删除客户表数据")
    @DeleteMapping("delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.ok(this.crmCustomerService.removeById(id));
    }

}

