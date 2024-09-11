package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 资源权限(SysMenu)表实体类
 *
 * @author makejava
 * @since 2024-03-27 09:29:25
 */
@Data
public class SysMenu implements Serializable {

	@Serial
	private static final long serialVersionUID = -27119110077071869L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 类型 1系统 2菜单 3按钮
	 */
	private Integer menuType;

	/**
	 * 父级ID
	 */
	private Long parentId;

	/**
	 * 路由标题
	 */
	private String title;

	/**
	 * 路由名称 不能重复
	 */
	private String name;

	/**
	 * 请求地址
	 */
	private String path;

	/**
	 * 组件地址
	 */
	private String component;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 角色标识
	 */
	private String roles;

	/**
	 * 权限标识
	 */
	private String auths;

	/**
	 * 层级
	 */
	private String layer;

	/**
	 * 是否显示在左侧
	 */
	private Integer hidden;

	/**
	 * 排序
	 */
	private Integer rank;

	/**
	 * 重定向
	 */
	private String redirect;

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

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime updateTime;

}
