package cn.yt4j.sys.service.impl;

import cn.yt4j.core.util.TreeUtil;
import cn.yt4j.security.util.SecurityUtil;
import cn.yt4j.sys.dao.SysMenuDao;
import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.entity.vo.*;
import cn.yt4j.sys.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 资源权限(SysMenu)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:33
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

	@Override
	public List<Route> nav(Long id, Long applicationId) {
		return Optional.ofNullable(this.baseMapper.listMenuByUserIdAndApplicationId(id, applicationId)).orElse(new ArrayList<>())
				.stream().map(sysMenu -> {
					Route route = new Route();
					route.setPath(sysMenu.getPath());
					route.setId(sysMenu.getId());
					route.setParentId(sysMenu.getParentId());
					route.setName(sysMenu.getLabel());
					route.setHidden(sysMenu.getHidden());
					route.setComponent(sysMenu.getComponent());
					route.setHideChildrenInMenu(false);
					Meta meta = new Meta();
					meta.setIcon(sysMenu.getIcon());
					meta.setTitle(sysMenu.getTitle());
					meta.setShow(true);
					meta.setPermission(
							Arrays.asList(Optional.ofNullable(sysMenu.getPermission()).orElse(null).split(",")));
					route.setMeta(meta);
					return route;
				}).collect(Collectors.toList());
	}

	@Override
	public List<MenuTreeVO> menuTree() {
		return TreeUtil.buildByRecursive(
				Optional.ofNullable(this.baseMapper.selectList(null)).orElse(null).stream().map(sysMenu -> {
					MenuTreeVO vo = new MenuTreeVO(sysMenu.getId(), sysMenu.getParentId(), sysMenu.getTitle(),
							sysMenu.getTitle(), sysMenu.getIcon(), sysMenu.getOrderNo(), sysMenu.getPath(),
							sysMenu.getComponent());
					return vo;
				}).collect(Collectors.toList()), 0L);
	}

	@Override
	public List<TopMenuVO> topMenu() {
		return this.baseMapper.listTopMenu(SecurityUtil.getUser().getId()).stream().map(sysMenu -> {
			TopMenuVO vo = new TopMenuVO();
			vo.setTitle(sysMenu.getTitle());
			vo.setId(sysMenu.getId());
			vo.setRedirect(sysMenu.getRedirect());
			return vo;
		}).collect(Collectors.toList());
	}

}
