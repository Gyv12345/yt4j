package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysUserDao;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-07 17:11:45
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}