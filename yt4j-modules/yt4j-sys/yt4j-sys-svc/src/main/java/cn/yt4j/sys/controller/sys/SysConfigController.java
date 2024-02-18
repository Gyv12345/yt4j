package cn.yt4j.sys.controller.sys;

import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.vo.SysConfigVO;
import cn.yt4j.sys.entity.SysConfig;
import cn.yt4j.sys.service.SysConfigService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.github.linpeilie.Converter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 系统配置(SysConfig)表控制层
 *
 * @author gyv12345@163.com
 */
@Tag(name = "系统配置")
@RequiredArgsConstructor
@RestController
@RequestMapping("config")
public class SysConfigController {

	/**
	 * 服务对象
	 */
	private final SysConfigService sysConfigService;

	private final Converter converter;

	/**
	 * 分页查询所有数据
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@SysLog("分页查询系统配置所有数据")
	@PostMapping("page")
	public Result<PageResult<SysConfig>> listPage(@Valid @RequestBody PageRequest<SysConfig> request) {
		return Result.ok(this.sysConfigService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@SysLog("通过主键查询系统配置单条数据")
	@GetMapping("get/{id}")
	public Result<SysConfig> selectOne(@PathVariable Long id) {
		return Result.ok(this.sysConfigService.getById(id));
	}

	/**
	 * 新增系统配置数据
	 * @param sysConfig 实体对象
	 * @return 新增结果
	 */
	@SysLog("新增客户表数据")
	@PostMapping("insert")
	public Result<Boolean> insert(@RequestBody SysConfig sysConfig) {
		return Result.ok(this.sysConfigService.save(sysConfig));
	}

	/**
	 * 修改系统配置数据
	 * @param sysConfig 实体对象
	 * @return 修改结果
	 */
	@SysLog("修改系统配置数据")
	@PutMapping("update")
	public Result<Boolean> update(@RequestBody SysConfig sysConfig) {
		return Result.ok(this.sysConfigService.updateById(sysConfig));
	}

	/**
	 * 删除系统配置数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@SysLog("删除系统配置数据")
	@DeleteMapping("delete/{id}")
	public Result<Boolean> delete(@PathVariable Long id) {
		return Result.ok(this.sysConfigService.removeById(id));
	}

	/**
	 * 根据key获取系统配置
	 * @param key key
	 * @return 配置
	 */
	@SysLog("根据key获取系统配置")
	@GetMapping("key")
	public Result<SysConfigVO> getSysConfigByKey(@RequestParam("key") String key) {
		SysConfig one = this.sysConfigService.getOne(Wrappers.<SysConfig>lambdaQuery().eq(SysConfig::getKey, key));
		return Result.ok(converter.convert(one, SysConfigVO.class));
	}

}
