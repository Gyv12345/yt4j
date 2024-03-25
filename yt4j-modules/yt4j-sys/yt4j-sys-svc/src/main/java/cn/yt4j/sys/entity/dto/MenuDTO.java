package cn.yt4j.sys.entity.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 菜单
 *
 * @author gyv12345@163.com
 */
@Data
public class MenuDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 684706447443499668L;

	/**
	 * 菜单类型
	 */
	private Integer menuType;

	/**
	 * 父级ID
	 */
	private Long parentId;

	/**
	 * 菜单名称
	 */
	private String title;

	/**
	 * 路由名称
	 */
	private String name;

	/**
	 * 路由路径
	 */
	private String path;

	/**
	 * 组件路径
	 */
	private String component;

	/**
	 * 菜单排序
	 */
	private Integer rank;

	/**
	 * 路由重定向
	 */
	private String redirect;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 右侧图标
	 */
	private String extraIcon;

	/**
	 * 进场动画
	 */
	private String enterTransition;

	/**
	 * 离场动画
	 */
	private String leaveTransition;

	/**
	 * 菜单激活
	 */
	private String activePath;

	/**
	 * 权限标识
	 */
	private String auths;

	/**
	 * 链接地址
	 */
	private String frameSrc;

	/**
	 * 加载动画
	 */
	private Boolean frameLoading;

	/**
	 * 缓存页面
	 */
	private Boolean keepAlive;

	/**
	 * 标签页
	 */
	private Boolean hiddenTag;

	/**
	 * 菜单是否可见
	 */
	private Boolean showLink;

	/**
	 * 父级菜单是否可见
	 */
	private Boolean showParent;

}
