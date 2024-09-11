
package cn.yt4j.sys.entity.vo;

import cn.yt4j.core.domain.BaseTree;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 前端路由
 *
 * @author gyv12345@163.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route extends BaseTree implements Serializable {

	@Serial
	private static final long serialVersionUID = 4000715486515628336L;

	/**
	 * 是否显示在左侧
	 */
	private Boolean hidden;

	/**
	 * 重定向
	 */
	private String redirect;

	/**
	 * 组件
	 */
	private String component;

	/**
	 * 组件路径
	 */
	private String path;

	/**
	 * 元数据
	 */
	private Meta meta;

	/**
	 * 是否隐藏子菜单
	 */
	private Boolean hideChildrenInMenu;

}
