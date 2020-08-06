package cn.yt4j.core.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseTree implements Serializable {

	private static final long serialVersionUID = -6535556067013322117L;

	@JsonSerialize(using = ToStringSerializer.class)
	public Long id;

	@JsonSerialize(using = ToStringSerializer.class)
	public Long parentId;

	public List<BaseTree> children = new ArrayList<>();

	public void add(BaseTree node) {
		children.add(node);
	}

	public BaseTree(Long id, Long parentId) {
		this.id = id;
		this.parentId = parentId;
	}

}
