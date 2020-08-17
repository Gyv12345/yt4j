package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysMenuDao;
import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.entity.vo.Meta;
import cn.yt4j.sys.entity.vo.Route;
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
    public List<Route> nav(Long id) {
        return Optional.ofNullable(this.baseMapper.listMenuByUserId(id)).orElse(null).stream().map(sysMenu -> {
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
            meta.setPermission(Arrays.asList(Optional.ofNullable(sysMenu.getPermission()).orElse(null).split(",")));
            route.setMeta(meta);
            return route;
        }).collect(Collectors.toList());
    }
}