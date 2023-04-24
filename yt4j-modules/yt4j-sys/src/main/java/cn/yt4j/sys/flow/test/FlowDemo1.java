
package cn.yt4j.sys.flow.test;

import cn.yt4j.flow.work.Work;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@Component
public class FlowDemo1 implements Work {

	@Override
	public int execute(Map<String, Object> context) {
		log.info("大于10岁");
		context.put("nikeName", "网二");
		return NEXT;
	}

}
