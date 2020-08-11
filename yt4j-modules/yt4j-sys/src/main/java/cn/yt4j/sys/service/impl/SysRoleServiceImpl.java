package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysRoleDao;
import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:34
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

}