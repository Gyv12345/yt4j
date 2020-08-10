package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysDeptDao;
import cn.yt4j.sys.entity.SysDept;
import cn.yt4j.sys.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门(SysDept)表服务实现类
 *
 * @author makejava
 * @since 2020-08-10 08:43:51
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

}