package cn.yt4j.sys.dao;

import cn.yt4j.sys.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 资源权限(SysMenu)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:33
 */
public interface SysMenuDao extends BaseMapper<SysMenu> {
	/**
	 * 获取权限
	 * @param id
	 * @return
	 */
	List<String> listByUserId(Long id);

	/**
	 * 根据用户ID查询菜单
	 * @return
	 */
	List<SysMenu> listMenuByUserId(Long id);

}