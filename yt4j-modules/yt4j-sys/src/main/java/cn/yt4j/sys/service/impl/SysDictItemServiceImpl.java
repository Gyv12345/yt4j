/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysDictItemDao;
import cn.yt4j.sys.entity.SysDictItem;
import cn.yt4j.sys.service.SysDictItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (SysDictItem)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-09-10 10:27:46
 */
@Service("sysDictItemService")
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemDao, SysDictItem> implements SysDictItemService {

}
