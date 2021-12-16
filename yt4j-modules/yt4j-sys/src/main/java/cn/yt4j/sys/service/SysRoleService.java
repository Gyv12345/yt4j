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

import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.entity.vo.DictVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色(SysRole)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:34
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * 设置角色权限
	 * @param dto
	 * @return
	 */
	Boolean setting(RoleMenuDTO dto);

	/**
	 * 批量获取已经选中的权限
	 * @param id
	 * @return
	 */
	List<Long> listMenuIds(Long id);

	/**
	 * 下拉框
	 * @return
	 */
	List<DictVO> dropDown();

}
