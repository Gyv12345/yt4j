/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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

		this.sysRoleMenuDao.delete(Wrappers.<SysRoleMenu>query().lambda().eq(SysRoleMenu::getRoleId, dto.getRoleId()));

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
		return this.baseMapper.selectList(null).stream().map(sysRole -> {
			DictVO vo = new DictVO();
			vo.setLabel(sysRole.getName());
			vo.setValue(String.valueOf(sysRole.getId()));
			return vo;
		}).collect(Collectors.toList());
	}

}
