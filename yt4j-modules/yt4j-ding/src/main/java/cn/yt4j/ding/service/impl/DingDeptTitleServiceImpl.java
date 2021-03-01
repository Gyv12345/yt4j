package cn.yt4j.ding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.yt4j.ding.dao.DingDeptTitleDao;
import cn.yt4j.ding.entity.DingDeptTitle;
import cn.yt4j.ding.service.DingDeptTitleService;
import org.springframework.stereotype.Service;

/**
 * 部门职位(DingDeptTitle)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2021-02-19 11:42:33
 */
@Service("dingDeptTitleService")
public class DingDeptTitleServiceImpl extends ServiceImpl<DingDeptTitleDao, DingDeptTitle>
		implements DingDeptTitleService {

}
