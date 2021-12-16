/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
