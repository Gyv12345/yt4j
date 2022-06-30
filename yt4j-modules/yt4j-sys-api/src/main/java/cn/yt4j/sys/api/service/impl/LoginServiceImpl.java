package cn.yt4j.sys.api.service.impl;

import cn.yt4j.core.domain.R;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.api.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public R<SysUser> getUserByUsername(String username) {
        return R.ok();
    }

    @Override
    public R<List<String>> listRoleByUserId(Long userId) {
        return R.ok();
    }

    @Override
    public R<List<String>> listMenuByUserId(Long userId) {
        return R.ok();
    }
}
