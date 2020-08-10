package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysRoleMenuDao;
import cn.yt4j.sys.entity.SysRoleMenu;
import cn.yt4j.sys.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色权限(SysRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-08-10 08:44:10
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

}