
package cn.yt4j.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.yt4j.core.constant.RedisConstants;
import cn.yt4j.core.domain.Result;
import cn.yt4j.flow.work.FlowTool;
import cn.yt4j.sys.entity.dto.FlowTestDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 简单demo演示
 *
 * @author gyv12345@163.com
 */
@Tag(name = "流程编排示例")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/flow")
public class FlowDemoController {

	private final FlowTool flowTool;

	private final RedisTemplate<String, String> redisTemplate;

	/**
	 * 测试流程
	 * @param info
	 * @return
	 */
	@PostMapping("test")
	public Result test(@RequestBody FlowTestDTO info) {
		Map<String, Object> context = BeanUtil.beanToMap(info);
		flowTool.getByName("test").execute(context);
		return Result.ok(context);
	}

	/**
	 * 测试推送消息
	 * @return
	 */
	@GetMapping("message")
	public Result message() {
		redisTemplate.convertAndSend(RedisConstants.MESSAGE_TOPIC, "hello world");
		return Result.ok();
	}

}
