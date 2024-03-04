package cn.yt4j.feishu.controller;

import cn.yt4j.core.domain.Result;
import cn.yt4j.feishu.service.FeiShuContactService;
import cn.yt4j.plugin.common.entity.BaseDept;
import cn.yt4j.plugin.common.entity.BaseUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 飞书相关的feign调用实现
 *
 * @author gyv12345@163.com
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "飞书")
@RequestMapping("feishu")
public class FeiShuController {

	private final FeiShuContactService feiShuContactService;

	/**
	 * 检查飞书服务是否存在
	 * @return true
	 */
	@GetMapping("check")
	public Result<Boolean> checkFeiShu() {
		return Result.ok(true);
	}

	/**
	 * 获取部门信息，三个IM的根部门值个不相同，所以需要在别处去实现
	 * @param deptId 部门ID
	 * @return 部门信息
	 */
	@GetMapping("dept")
	public Result<List<BaseDept>> getDept(@RequestParam String deptId) {
		return Result.ok(this.feiShuContactService.getDept(deptId));
	}

	/**
	 * 获取用户信息
	 * @param deptId 部门ID
	 * @return 用户信息
	 */
	@GetMapping("user")
	public Result<List<BaseUser>> getUser(@RequestParam String deptId) {
		return Result.ok(this.feiShuContactService.getUser(deptId));
	}

}
