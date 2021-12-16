/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
