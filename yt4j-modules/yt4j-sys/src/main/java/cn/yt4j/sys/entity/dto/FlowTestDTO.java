
package cn.yt4j.sys.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gyv12345@163.com
 */
@Schema(description = "流程实体")
@Data
public class FlowTestDTO {

	@Schema(description = "年龄")
	private Integer age;

}
