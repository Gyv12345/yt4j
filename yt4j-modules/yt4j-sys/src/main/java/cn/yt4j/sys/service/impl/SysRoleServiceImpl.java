/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysRoleDao;
import cn.yt4j.sys.dao.SysRoleMenuDao;
import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.entity.SysRoleMenu;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.entity.vo.DictVO;
import cn.yt4j.sys.service.SysRoleService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:34
 */
@RequiredArgsConstructor
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

	private final SysRoleMenuDao sysRoleMenuDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean setting(RoleMenuDTO dto) {
		this.sysRoleMenuDao.delete(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId, dto.getRoleId()));
		this.sysRoleMenuDao.batchAdd(dto.getMenuIds(), dto.getRoleId());
		return Boolean.TRUE;
	}

	@Override
	public List<Long> listMenuIds(Long id) {
		return this.sysRoleMenuDao.selectList(Wrappers.<SysRoleMenu>query().lambda().eq(SysRoleMenu::getRoleId, id))
				.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
	}

	@Override
	public List<DictVO> dropDown() {
		return this.list().stream().map(sysRole -> {
			DictVO vo = new DictVO();
			vo.setLabel(sysRole.getName());
			vo.setValue(String.valueOf(sysRole.getId()));
			return vo;
		}).collect(Collectors.toList());
	}

}
