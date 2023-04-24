
package cn.yt4j.sys.service.impl;

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.core.enums.BasicEnum;
import cn.yt4j.core.util.TreeUtil;
import cn.yt4j.sys.api.entity.SysDept;
import cn.yt4j.sys.dao.SysDeptDao;
import cn.yt4j.sys.service.SysDeptService;
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
		return TreeUtil
				.buildByRecursive(Optional.ofNullable(this.list()).orElse(new ArrayList<>()).stream().map(sysDept -> {
					BaseTree tree = new BaseTree();
					tree.setId(sysDept.getId());
					tree.setParentId(sysDept.getParentId());
					tree.setName(sysDept.getLabel());
					return tree;
				}).collect(Collectors.toList()), BasicEnum.PARENT.getId());
	}

}
