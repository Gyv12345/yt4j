
package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
public class UserInfo implements Serializable {

	private static final long serialVersionUID = -7219556137655994917L;

	private String name;

	private String avatar;

	private String job;

	private String organization;

	private String location;

	private String email;

	private String introduction;

	private String personalWebsite;

	private String jobName;

	private String organizationName;

	private String locationName;

	private String phone;

	private String registrationDate;

	private String accountId;

	private String certification;

	private String role;

}
