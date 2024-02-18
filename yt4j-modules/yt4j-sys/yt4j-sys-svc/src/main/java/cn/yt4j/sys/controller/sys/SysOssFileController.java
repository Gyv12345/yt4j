package cn.yt4j.sys.controller.sys;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.entity.SysOssFile;
import cn.yt4j.sys.service.SysOssFileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 文件记录表(SysOssFile)表控制层
 *
 * @author gyv12345@163.com
 * @since 2023-12-18 22:19:46
 */
@Tag(name = "文件记录表")
@RequiredArgsConstructor
@RestController
@RequestMapping("oss")
public class SysOssFileController {

	/**
	 * 服务对象
	 */
	private final SysOssFileService sysOssFileService;

	/**
	 * 分页查询所有数据
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@SysLog("分页查询文件记录表所有数据")
	@PostMapping("page")
	public Result<PageResult<SysOssFile>> listPage(@Valid @RequestBody PageRequest<SysOssFile> request) {
		return Result.ok(this.sysOssFileService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@SysLog("通过主键查询文件记录表单条数据")
	@GetMapping("get/{id}")
	public Result<SysOssFile> selectOne(@PathVariable Long id) {
		return Result.ok(this.sysOssFileService.getById(id));
	}

	/**
	 * 新增文件记录表数据
	 * @param sysOssFile 实体对象
	 * @return 新增结果
	 */
	@SysLog("新增客户表数据")
	@PostMapping("insert")
	public Result<Boolean> insert(@RequestBody SysOssFile sysOssFile) {
		return Result.ok(this.sysOssFileService.save(sysOssFile));
	}

	/**
	 * 修改文件记录表数据
	 * @param sysOssFile 实体对象
	 * @return 修改结果
	 */
	@SysLog("修改文件记录表数据")
	@PutMapping("update")
	public Result<Boolean> update(@RequestBody SysOssFile sysOssFile) {
		return Result.ok(this.sysOssFileService.updateById(sysOssFile));
	}

	/**
	 * 删除文件记录表数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@SysLog("删除文件记录表数据")
	@DeleteMapping("delete/{id}")
	public Result<Boolean> delete(@PathVariable Long id) {
		return Result.ok(this.sysOssFileService.removeById(id));
	}

}
