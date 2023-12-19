
package cn.yt4j.sys.controller.sys;

import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.sys.api.entity.SysDictItem;
import cn.yt4j.sys.service.SysDictItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 字段项(SysDictItem)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-09-10 10:29:08
 */
@Tag(name = "字典项")
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/item")
public class SysDictItemController {

	/**
	 * 服务对象
	 */
	private final SysDictItemService sysDictItemService;

	/**
	 * 分页查询所有数据
	 * @param sysDictItem 查询实体
	 * @return 所有数据
	 */
	@GetMapping
	public Result<PageResult<SysDictItem>> selectAll(SysDictItem sysDictItem) {
		return Result.ok(this.sysDictItemService.page(PageUtil.page(), new QueryWrapper<>(sysDictItem)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("{id}")
	public Result<SysDictItem> selectOne(@PathVariable Serializable id) {
		return Result.ok(this.sysDictItemService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDictItem 实体对象
	 * @return 新增结果
	 */
	@PostMapping
	public Result<Boolean> insert(@RequestBody SysDictItem sysDictItem) {
		return Result.ok(this.sysDictItemService.save(sysDictItem));
	}

	/**
	 * 批量添加
	 * @param list 实体对象
	 * @return 结果
	 */
	@PostMapping("batch/insert")
	public Result<Boolean> batchInsert(@RequestBody List<SysDictItem> list) {
		return Result.ok(this.sysDictItemService.saveBatch(list));
	}

	/**
	 * 修改数据
	 * @param sysDictItem 实体对象
	 * @return 修改结果
	 */
	@PutMapping
	public Result<Boolean> update(@RequestBody SysDictItem sysDictItem) {
		return Result.ok(this.sysDictItemService.updateById(sysDictItem));
	}

	/**
	 * 删除数据
	 * @param id 主键
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public Result<Boolean> delete(@PathVariable Long id) {
		return Result.ok(this.sysDictItemService.removeById(id));
	}

}
