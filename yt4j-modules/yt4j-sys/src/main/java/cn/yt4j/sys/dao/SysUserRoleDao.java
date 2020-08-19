package cn.yt4j.sys.dao;

import cn.yt4j.sys.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:10
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

	/**
	 * 批量添加
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	int batchAdd(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

}