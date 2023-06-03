
package cn.yt4j.sys.controller;

import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysDict;
import cn.yt4j.sys.entity.vo.DictVO;
import cn.yt4j.sys.service.SysDictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典(SysDict)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:32
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict")
public class SysDictController {

	/**
	 * 服务对象
	 */
	private final SysDictService sysDictService;

	/**
	 * 获取远程字典
	 * @param code
	 * @return
	 */
	@SysLog("获取远程字典")
	@GetMapping("remote/{code}")
	public R<List<DictVO>> listByCode(@PathVariable String code) {
		return R.ok(this.sysDictService.listByCode(code).stream().map(sysDictItem -> {
			DictVO vo = new DictVO();
			vo.setLabel(sysDictItem.getLabel());
			vo.setValue(sysDictItem.getValue());
			return vo;
		}).collect(Collectors.toList()));
	}

	/**
	 * 分页查询所有数据
	 * @param sysDict 查询实体
	 * @return 所有数据
	 */
	@GetMapping
	public R<PageResult<SysDict>> selectAll(SysDict sysDict) {
		return R.ok(this.sysDictService.page(PageUtil.page(), new QueryWrapper<>(sysDict)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("{id}")
	public R<SysDict> selectOne(@PathVariable Serializable id) {
		return R.ok(this.sysDictService.getById(id));
	}

	/**
	 * 新增数据
	 * @param sysDict 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public R insert(@RequestBody SysDict sysDict) {
		return R.ok(this.sysDictService.save(sysDict));
	}

	/**
	 * 修改数据
	 * @param sysDict 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public R update(@RequestBody SysDict sysDict) {
		return R.ok(this.sysDictService.updateById(sysDict));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysDictService.removeById(id));
	}

}
