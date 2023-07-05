
package cn.yt4j.core.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 基本树，基本上可以满足树了
 *
 * @author gyv12345@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseTree implements Serializable {

	@Serial
	private static final long serialVersionUID = -6535556067013322117L;

	@Schema(description = "ID")
	@JsonSerialize(using = ToStringSerializer.class)
	public Long id;

	@Schema(description = "父ID")
	@JsonSerialize(using = ToStringSerializer.class)
	public Long parentId;

	@Schema(description = "名称")
	private String name;

	@Schema(description = "子集")
	public List<BaseTree> children = new ArrayList<>();

	public void add(BaseTree node) {
		children.add(node);
	}

	public BaseTree(Long id, Long parentId, String name) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
	}

}
