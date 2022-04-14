/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.flow.test;

import cn.yt4j.flow.work.Work;
import cn.yt4j.flow.work.WorkContext;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.FlowTestDTO;
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
