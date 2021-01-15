package cn.yt4j.ding.service.impl;

import cn.yt4j.ding.dao.DingUserDao;
import cn.yt4j.ding.entity.DingUser;
import cn.yt4j.ding.service.DingUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 钉钉的用户(DingUser)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2021-01-15 08:38:44
 */
@Service("dingUserService")
public class DingUserServiceImpl extends ServiceImpl<DingUserDao, DingUser> implements DingUserService {

}
