/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.service;

import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.entity.vo.MenuTreeVO;
import cn.yt4j.sys.entity.vo.Route;
import cn.yt4j.sys.entity.vo.TopMenuVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 资源权限(SysMenu)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:33
 */
public interface SysMenuService extends IService<SysMenu> {

	/**
	 * 左侧菜单
	 * @param id
	 * @param applicationId
	 * @return
	 */
	List<Route> nav(Long id, Long applicationId);

	/**
	 * 获取菜单树形列表
	 * @return
	 */
	List<MenuTreeVO> menuTree();

	/**
	 * 应用菜单
	 * @return
	 */
	List<TopMenuVO> topMenu();

}
