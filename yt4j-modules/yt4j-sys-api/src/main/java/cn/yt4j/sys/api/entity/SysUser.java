
package cn.yt4j.sys.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户(SysUser)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:42
 */
@Getter
@Setter
@ToString
public class SysUser extends Model<SysUser> {

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
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
	@TableField(exist = false)
	private List<Long> roleIds;

}
