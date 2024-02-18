
package cn.yt4j.sys.service.impl;

import cn.yt4j.sys.entity.SysDict;
import cn.yt4j.sys.entity.SysDictItem;
import cn.yt4j.sys.mapper.SysDictItemMapper;
import cn.yt4j.sys.mapper.SysDictMapper;
import cn.yt4j.sys.service.SysDictService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典(SysDict)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:32
 */
@RequiredArgsConstructor
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

	private final SysDictItemMapper sysDictItemMapper;

	@Override
	public List<SysDictItem> listByCode(String code) {
		return sysDictItemMapper.selectList(Wrappers.<SysDictItem>lambdaQuery().eq(SysDictItem::getCode, code));
	}

}
