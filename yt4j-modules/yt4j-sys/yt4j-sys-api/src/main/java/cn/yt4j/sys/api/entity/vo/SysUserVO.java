
package cn.yt4j.sys.api.entity.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户(SysUser)表实体类
 *
 * @author gyv12345@163.com
 */
@Data
public class SysUserVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 7933811141095706987L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 身份证
	 */
	private String idCard;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 状态
	 */
	private Boolean state;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 角色
	 */
	private List<Long> roleIds;

}
