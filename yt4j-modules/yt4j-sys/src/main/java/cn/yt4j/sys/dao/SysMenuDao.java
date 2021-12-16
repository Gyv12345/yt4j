/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
