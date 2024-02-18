
package cn.yt4j.sys.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
public class UserInfo implements Serializable {

	private static final long serialVersionUID = -7219556137655994917L;

	/**
	 * 个人姓名
	 */
	private String name;

	/**
	 * 个人头像
	 */
	private String avatar;

	/**
	 * 个人职业
	 */
	private String job;

	/**
	 * 个人所属组织
	 */
	private String organization;

	/**
	 * 个人所在地
	 */
	private String location;

	/**
	 * 个人邮箱
	 */
	private String email;

	/**
	 * 个人简介
	 */
	private String introduction;

	/**
	 * 个人个人网站
	 */
	private String personalWebsite;

	/**
	 * 个人职位名称
	 */
	private String jobName;

	/**
	 * 个人所属组织名称
	 */
	private String organizationName;

	/**
	 * 个人所在地名称
	 */
	private String locationName;

	/**
	 * 个人电话
	 */
	private String phone;

	/**
	 * 个人注册日期
	 */
	private String registrationDate;

	/**
	 * 个人账号ID
	 */
	private String accountId;

	/**
	 * 个人证书
	 */
	private String certification;

	/**
	 * 个人角色
	 */
	private String role;

}
