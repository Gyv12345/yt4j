package cn.yt4j.flowserver.controller;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.flowserver.entity.FlowInfo;
import cn.yt4j.flowserver.service.FlowInfoService;
import cn.yt4j.log.annotation.SysLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * 流程信息(FlowInfo)表控制层
 *
 * @author gyv12345@163.com
 * @since 2023-08-11 11:26:39
 */
@Tag(name = "流程信息")
@RequiredArgsConstructor
@RestController
@RequestMapping("flowInfo")
public class FlowInfoController {

	/**
	 * 服务对象
	 */
	private final FlowInfoService flowInfoService;

	/**
	 * 分页查询所有数据
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@SysLog("分页查询流程信息所有数据")
	@PostMapping("page")
	public Result<PageResult<FlowInfo>> listPage(@Valid @RequestBody PageRequest<FlowInfo> request) {
		return Result.ok(this.flowInfoService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@SysLog("通过主键查询流程信息单条数据")
	@GetMapping("get/{id}")
	public Result<FlowInfo> selectOne(@PathVariable Serializable id) {
		return Result.ok(this.flowInfoService.getById(id));
	}

	/**
	 * 新增流程信息数据
	 * @param flowInfo 实体对象
	 * @return 新增结果
	 */
	@SysLog("新增客户表数据")
	@PostMapping("insert")
	public Result insert(@RequestBody FlowInfo flowInfo) {
		return Result.ok(this.flowInfoService.save(flowInfo));
	}

	/**
	 * 修改流程信息数据
	 * @param flowInfo 实体对象
	 * @return 修改结果
	 */
	@SysLog("修改流程信息数据")
	@PutMapping("update")
	public Result update(@RequestBody FlowInfo flowInfo) {
		return Result.ok(this.flowInfoService.updateById(flowInfo));
	}

	/**
	 * 删除流程信息数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@SysLog("删除流程信息数据")
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable Long id) {
		return Result.ok(this.flowInfoService.removeById(id));
	}

}
