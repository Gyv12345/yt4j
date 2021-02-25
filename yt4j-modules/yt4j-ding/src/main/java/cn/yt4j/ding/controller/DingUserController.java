package cn.yt4j.ding.controller;

import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.ding.entity.DingUser;
import cn.yt4j.ding.service.DingUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 钉钉的用户(DingUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2021-01-15 08:38:46
 */
@Api(tags = " 钉钉的用户")
@AllArgsConstructor
@RestController
@RequestMapping("dingUser")
public class DingUserController {

	/**
	 * 服务对象
	 */
	private final DingUserService dingUserService;

	/**
	 * 分页查询所有数据
	 * @param dingUser 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("分页查询")
	@GetMapping("page")
	public R<PageResult<DingUser>> listPage(DingUser dingUser) {
		return R.ok(this.dingUserService.page(PageUtil.page(), new QueryWrapper<>(dingUser)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("获取单个")
	@GetMapping("{id}")
	public R<DingUser> get(@PathVariable Serializable id) {
		return R.ok(this.dingUserService.getById(id));
	}

	/**
	 * 新增数据
	 * @param dingUser 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加")
	@PostMapping("insert")
	public R<Boolean> insert(@RequestBody DingUser dingUser) {
		return R.ok(this.dingUserService.save(dingUser));
	}

	/**
	 * 修改数据
	 * @param dingUser 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改")
	@PutMapping("udpate")
	public R<Boolean> update(@RequestBody DingUser dingUser) {
		return R.ok(this.dingUserService.updateById(dingUser));
	}

	/**
	 * 删除数据
	 * @param idList 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping("delete")
	public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
		return R.ok(this.dingUserService.removeByIds(idList));
	}

}
