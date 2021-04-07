/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.dao;

import cn.yt4j.sys.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源权限(SysMenu)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:33
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {

	/**
	 * 获取权限
	 * @param id
	 * @return
	 */
	List<String> listByUserId(Long id);

	/**
	 * 查询菜单，不涉及顶级菜单，和按钮
	 * @param id
	 * @param applicationId
	 * @return
	 */
	List<SysMenu> listMenuByUserIdAndApplicationId(@Param("id") Long id, @Param("applicationId") Long applicationId);

	/**
	 * 查询全部权限
	 * @param id
	 * @return
	 */
	List<SysMenu> listMenuByUserId(Long id);

	/**
	 * 应用菜单
	 * @param id
	 * @return
	 */
	List<SysMenu> listTopMenu(Long id);

}
