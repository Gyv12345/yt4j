
package cn.yt4j.sys.mapper;

import cn.yt4j.sys.api.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限(SysRoleMenu)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:09
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	/**
	 * 批量添加
	 * @param menuIds
	 * @param roleId
	 * @return
	 */
	int batchAdd(@Param("menuIds") List<Long> menuIds, @Param("roleId") Long roleId);

}
