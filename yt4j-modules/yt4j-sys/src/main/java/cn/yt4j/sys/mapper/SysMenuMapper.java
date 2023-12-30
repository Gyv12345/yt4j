
package cn.yt4j.sys.mapper;

import cn.yt4j.sys.api.entity.SysMenu;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 获取权限
	 * @param id 用户ID
	 * @return 结果
	 */
	List<String> listByUserId(Long id);

	/**
	 * 查询菜单，不涉及顶级菜单，和按钮
	 * @param id 用户ID
	 * @param applicationId 应用ID
	 * @return 结果
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
