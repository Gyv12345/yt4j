/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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
		return TreeUtil.buildByRecursive(Optional.ofNullable(this.baseMapper.selectList(new QueryWrapper<>()))
				.orElse(new ArrayList<>()).stream().map(sysDept -> {
					BaseTree tree = new BaseTree();
					tree.setId(sysDept.getId());
					tree.setParentId(sysDept.getParentId());
					tree.setName(sysDept.getLabel());
					return tree;
				}).collect(Collectors.toList()), 0L);
	}

}
