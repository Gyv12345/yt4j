package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysMenuDao;
import cn.yt4j.sys.entity.SysMenu;
import cn.yt4j.sys.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 资源权限(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-08-10 08:43:33
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}