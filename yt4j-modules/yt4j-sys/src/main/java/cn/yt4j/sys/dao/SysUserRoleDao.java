/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.dao;

import cn.yt4j.sys.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:10
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

	/**
	 * 批量添加
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	int batchAdd(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

}
