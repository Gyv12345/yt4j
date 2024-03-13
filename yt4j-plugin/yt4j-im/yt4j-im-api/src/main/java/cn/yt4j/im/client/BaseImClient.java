package cn.yt4j.im.client;

import cn.yt4j.im.entity.BaseDept;
import cn.yt4j.im.entity.BaseUser;

import java.util.List;

/**
 * 飞书的feign接口
 *
 * @author gyv12345@163.com
 */
public interface BaseImClient {

	/**
	 * 判断飞书模块是否存在
	 * @return
	 */
	String check();

	/**
	 * 获取部门信息
	 * @param deptId 部门iD
	 * @return
	 */
	List<BaseDept> getDept(String deptId);

	/**
	 * 根据部门获取用户信息
	 * @param deptId 部门iD
	 * @return
	 */
	List<BaseUser> getUser(String deptId);

}
