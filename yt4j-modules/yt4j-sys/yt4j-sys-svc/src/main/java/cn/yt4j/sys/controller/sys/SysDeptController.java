
package cn.yt4j.sys.controller.sys;

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.entity.SysDept;
import cn.yt4j.sys.service.SysDeptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 部门(SysDept)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:51
 */
@Tag(name = "部门")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/dept")
public class SysDeptController {

	/**
	 * 服务对象
	 */
	private final SysDeptService sysDeptService;

	/**
	 * 机构树
	 * @return 结果
	 */
	@SysLog("获取部门机构树")
	@GetMapping("tree")
	public Result<List<BaseTree>> treeDept() {
		return Result.ok(this.sysDeptService.treeDept());
	}

	/**
	 * 部门分页查询
	 * @param pageRequest 分页请求对象
	 * @return 结果
	 */
	@SysLog("部门分页查询")
	@PostMapping("page")
	public Result<PageResult<SysDept>> selectAll(@RequestBody PageRequest<SysDept> pageRequest) {
		return Result.ok(this.sysDeptService.page(pageRequest.page(), pageRequest.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("get/{id}")
	public Result<SysDept> selectOne(@PathVariable Serializable id) {
		return Result.ok(this.sysDeptService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDept 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public Result<Boolean> insert(@RequestBody SysDept sysDept) {
		return Result.ok(this.sysDeptService.save(sysDept));
	}

	/**
	 * 修改数据
	 * @param sysDept 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public Result<Boolean> update(@RequestBody SysDept sysDept) {
		return Result.ok(this.sysDeptService.updateById(sysDept));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public Result<Boolean> delete(@PathVariable Long id) {
		return Result.ok(this.sysDeptService.removeById(id));
	}

}
