/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.service;

import cn.yt4j.sys.entity.SysDict;
import cn.yt4j.sys.entity.SysDictItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 字典(SysDict)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:32
 */
public interface SysDictService extends IService<SysDict> {

	/**
	 * 添加
	 * @param dict
	 * @return
	 */
	Boolean insert(SysDict dict);

	/**
	 * 修改
	 * @param dict
	 * @return
	 */
	Boolean update(SysDict dict);

	/**
	 * 远程字典
	 * @param code
	 * @return
	 */
	List<SysDictItem> listByCode(String code);

}
