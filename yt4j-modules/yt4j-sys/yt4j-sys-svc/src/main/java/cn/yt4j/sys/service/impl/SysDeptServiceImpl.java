
package cn.yt4j.sys.service.impl;

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.core.enums.BasicEnum;
import cn.yt4j.core.util.TreeUtil;
import cn.yt4j.im.client.BaseImClient;
import cn.yt4j.sys.entity.SysDept;
import cn.yt4j.sys.mapper.SysDeptMapper;
import cn.yt4j.sys.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

	private final BaseImClient client;

	@Override
	public List<BaseTree> treeDept() {
		return TreeUtil
			.buildByRecursive(Optional.ofNullable(this.list()).orElse(new ArrayList<>()).stream().map(sysDept -> {
				BaseTree tree = new BaseTree();
				tree.setId(sysDept.getId());
				tree.setParentId(sysDept.getParentId());
				tree.setName(sysDept.getName());
				return tree;
			}).collect(Collectors.toList()), BasicEnum.PARENT.getId());
	}

	@Override
	public String syncDept() {
		client.check();
		return null;
	}

}
