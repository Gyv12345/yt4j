package cn.yt4j.im.entity;

import lombok.Data;

/**
 * 基本用户信息
 *
 * @author gyv12345@163.com
 */
@Data
public class BaseUser {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 上级
	 */
	private String leader;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * openId
	 */
	private String openId;

}
