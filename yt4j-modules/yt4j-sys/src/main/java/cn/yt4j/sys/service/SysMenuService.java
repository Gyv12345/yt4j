package cn.yt4j.sys.service;

import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.entity.vo.MenuTreeVO;
import cn.yt4j.sys.entity.vo.Route;
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
	 * 查询用户菜单
	 * @param id 用户ID
	 * @return
	 */
	List<Route> nav(Long id);

	/**
	 * 获取菜单树形列表
	 * @return
	 */
	List<MenuTreeVO> menuTree();

}