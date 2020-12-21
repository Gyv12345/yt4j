package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.dao.SysDictDao;
import cn.yt4j.sys.dao.SysDictItemDao;
import cn.yt4j.sys.entity.SysDict;
import cn.yt4j.sys.entity.SysDictItem;
import cn.yt4j.sys.service.SysDictService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典(SysDict)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:32
 */
@AllArgsConstructor
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDict> implements SysDictService {

	private final SysDictItemDao sysDictItemDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean insert(SysDict dict) {

		return this.baseMapper.insert(dict) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean update(SysDict dict) {

		return this.baseMapper.updateById(dict) > 0;
	}

	@Override
	public List<SysDictItem> listByCode(String code) {
		return sysDictItemDao.selectList(Wrappers.<SysDictItem>query().lambda().eq(SysDictItem::getCode, code));
	}

}