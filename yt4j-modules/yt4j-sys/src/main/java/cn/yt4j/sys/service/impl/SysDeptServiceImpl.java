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

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.core.util.TreeUtil;
import cn.yt4j.sys.dao.SysDeptDao;
import cn.yt4j.sys.entity.SysDept;
import cn.yt4j.sys.service.SysDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 部门(SysDept)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:51
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

	@Override
	public List<BaseTree> treeDept() {
		return TreeUtil.buildByRecursive(Optional.ofNullable(this.list())
				.orElse(new ArrayList<>()).stream().map(sysDept -> {
					BaseTree tree = new BaseTree();
					tree.setId(sysDept.getId());
					tree.setParentId(sysDept.getParentId());
					tree.setName(sysDept.getLabel());
					return tree;
				}).collect(Collectors.toList()), 0L);
	}

}
