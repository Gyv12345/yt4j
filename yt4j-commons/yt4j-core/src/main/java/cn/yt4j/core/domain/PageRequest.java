
package cn.yt4j.core.domain;

import cn.hutool.core.map.MapUtil;
import cn.yt4j.core.util.SearchUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class PageRequest<T> implements Serializable {

	@Serial
	private static final long serialVersionUID = -2788877367261112273L;

	/**
	 * 第几页
	 */
	@Schema(description = "页码")
	private Long pageNo;

	/**
	 * 每页条数
	 */
	@Schema(description = "条数")
	private Long pageSize;

	/**
	 * 查询条件
	 *
	 */
	@Schema(description = "查询条件 like_name:wang")
	private Map<String, Object> condition;

	/**
	 * 实体类
	 */
	private T data;

	public IPage<T> page() {
		return new Page<>(this.pageNo, this.pageSize);
	}

	public Wrapper wrapper() {
		if (MapUtil.isEmpty(this.condition)) {
			return new QueryWrapper();
		}
		return SearchUtil.parseWhereSql(this.condition);
	}

}
