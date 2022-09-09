package cn.yt4j.sys.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class MetaVO implements Serializable {

    private static final long serialVersionUID = 1882626219525850157L;
    /**
     * 配置能访问该页面的角色，如果不匹配，则会被禁止访问该路由页面
     */
    private List<String> roles;
    /**
     * 是否需要登录鉴权
     * 默认值 false
     */
    private Boolean requiresAuth;
    /**
     * 菜单配置icon
     */
    private String icon;
    /**
     * 一级菜单名（语言包键名）
     */
    private String locale;
    /**
     * 是否在左侧菜单中隐藏该项
     */
    private Boolean hideInMenu;
    /**
     * 强制在左侧菜单中显示单项
     */
    private Boolean hideChildrenInMenu;
    /**
     * 高亮设置的菜单项
     */
    private String activeMenu;
    /**
     * 排序路由菜单项。如果设置该值，值越高，越靠前
     */
    private Integer order;
    /**
     * 如果设置为true，标签将不会添加到tab-bar中
     */
    private Boolean noAffix;
    /**
     * 如果设置为true页面将不会被缓存
     */
    private Boolean ignoreCache;
}
