package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysRoleDao;
import cn.yt4j.sys.dao.SysRoleMenuDao;
import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.entity.SysRoleMenu;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.service.SysRoleService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:34
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

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

}