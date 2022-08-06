package cn.yt4j.crm.controller;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.crm.entity.CrmCustomer;
import cn.yt4j.crm.service.CrmCustomerService;
import cn.yt4j.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * 客户表(CrmCustomer)表控制层
 *
 * @author gyv12345@163.com
 * @since 2022-08-04 21:02:48
 */

@Api(tags = "客户表")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("customer")
public class CrmCustomerController {

	/**
	 * 服务对象
	 */
	private final CrmCustomerService crmCustomerService;

	/**
	 * 分页查询所有数据
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("分页查询客户表所有数据")
	@SysLog("分页查询客户表所有数据")
	@PostMapping("page")
	public R<PageResult<CrmCustomer>> listPage(@Valid @RequestBody PageRequest<CrmCustomer> request) {
		return R.ok(this.crmCustomerService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("通过主键查询客户表单条数据")
	@SysLog("通过主键查询客户表单条数据")
	@GetMapping("get/{id}")
	public R<CrmCustomer> selectOne(@PathVariable Serializable id) {
		return R.ok(this.crmCustomerService.getById(id));
	}

	/**
	 * 新增客户表数据
	 * @param crmCustomer 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("新增客户表数据")
	@SysLog("新增客户表数据")
	@PostMapping("insert")
	public R insert(@RequestBody CrmCustomer crmCustomer) {
		return R.ok(this.crmCustomerService.save(crmCustomer));
	}

	/**
	 * 修改客户表数据
	 * @param crmCustomer 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改客户表数据")
	@SysLog("修改客户表数据")
	@PutMapping("update")
	public R update(@RequestBody CrmCustomer crmCustomer) {
		return R.ok(this.crmCustomerService.updateById(crmCustomer));
	}

	/**
	 * 删除客户表数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除客户表数据")
	@SysLog("删除客户表数据")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.crmCustomerService.removeById(id));
	}

}
