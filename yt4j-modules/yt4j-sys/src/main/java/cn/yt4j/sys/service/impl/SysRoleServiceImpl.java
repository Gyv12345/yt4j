
package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.api.entity.SysRole;
import cn.yt4j.sys.api.entity.SysRoleMenu;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.entity.vo.DictVO;
import cn.yt4j.sys.mapper.SysRoleMapper;
import cn.yt4j.sys.mapper.SysRoleMenuMapper;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

	private final SysRoleMenuMapper sysRoleMenuMapper;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean setting(RoleMenuDTO dto) {
		this.sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId, dto.getRoleId()));
		this.sysRoleMenuMapper.batchAdd(dto.getMenuIds(), dto.getRoleId());
		return Boolean.TRUE;
	}

	@Override
	public List<Long> listMenuIds(Long id) {
		return this.sysRoleMenuMapper.selectList(Wrappers.<SysRoleMenu>query().lambda().eq(SysRoleMenu::getRoleId, id))
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

	@Override
	public List<String> listByUserId(Long userId) {
		return this.baseMapper.listByUserId(userId);
	}

}
