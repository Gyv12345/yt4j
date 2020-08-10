package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysDictDao;
import cn.yt4j.sys.entity.SysDict;
import cn.yt4j.sys.service.SysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 字典(SysDict)表服务实现类
 *
 * @author makejava
 * @since 2020-08-10 08:43:32
 */
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDict> implements SysDictService {

}