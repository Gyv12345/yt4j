
package cn.yt4j.sys.entity.vo;

import cn.yt4j.core.domain.BaseTree;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuTreeVO extends BaseTree {

	@Serial
	private static final long serialVersionUID = 7541326659328732790L;

	/**
	 * 菜单名称
	 */
	private String title;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 排序
	 */
	private Integer orderNo;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 组件路径
	 */
	private String component;

	public MenuTreeVO() {
	}

	public MenuTreeVO(Long id, Long parentId, String name, List<BaseTree> children, String title, String icon,
			Integer orderNo, String path, String component) {
		super(id, parentId, name, children);
		this.title = title;
		this.icon = icon;
		this.orderNo = orderNo;
		this.path = path;
		this.component = component;
	}

	public MenuTreeVO(Long id, Long parentId, String name, String title, String icon, Integer orderNo, String path,
			String component) {
		super(id, parentId, name);
		this.title = title;
		this.icon = icon;
		this.orderNo = orderNo;
		this.path = path;
		this.component = component;
	}

}
