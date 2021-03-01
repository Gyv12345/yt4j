package cn.yt4j.ding.controller;

import cn.yt4j.core.domain.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

import cn.yt4j.ding.entity.DingDeptTitle;
import cn.yt4j.ding.service.DingDeptTitleService;

/**
 * 部门职位(DingDeptTitle)表控制层
 *
 * @author gyv12345@163.com
 * @since 2021-02-19 11:42:33
 */
@Api(tags = " 部门职位")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("dingDeptTitle")
public class DingDeptTitleController {

	/**
	 * 服务对象
	 */
	private final DingDeptTitleService dingDeptTitleService;

	/**
	 * 分页查询所有数据
	 * @param dingDeptTitle 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("分页查询")
	@GetMapping("page")
	public R<PageResult<DingDeptTitle>> listPage(DingDeptTitle dingDeptTitle) {
		return R.ok(this.dingDeptTitleService.page(PageUtil.page(), new QueryWrapper<>(dingDeptTitle)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("获取单个")
	@GetMapping("{id}")
	public R<DingDeptTitle> get(@PathVariable Serializable id) {
		return R.ok(this.dingDeptTitleService.getById(id));
	}

	/**
	 * 新增数据
	 * @param dingDeptTitle 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加")
	@PostMapping("insert")
	public R<Boolean> insert(@RequestBody DingDeptTitle dingDeptTitle) {
		return R.ok(this.dingDeptTitleService.save(dingDeptTitle));
	}

	/**
	 * 修改数据
	 * @param dingDeptTitle 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改")
	@PutMapping("update")
	public R<Boolean> update(@RequestBody DingDeptTitle dingDeptTitle) {
		return R.ok(this.dingDeptTitleService.updateById(dingDeptTitle));
	}

	/**
	 * 删除数据
	 * @param idList 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping("delete")
	public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
		return R.ok(this.dingDeptTitleService.removeByIds(idList));
	}

}
