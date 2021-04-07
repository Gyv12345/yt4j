/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.service;

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.sys.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 部门(SysDept)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:51
 */
public interface SysDeptService extends IService<SysDept> {

	/**
	 * 查询部门树
	 * @return
	 */
	List<BaseTree> treeDept();

}
