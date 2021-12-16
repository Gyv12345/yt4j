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
