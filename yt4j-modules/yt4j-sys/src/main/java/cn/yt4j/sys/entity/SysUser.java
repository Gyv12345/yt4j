package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户(SysUser)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:42
 */
@ApiModel(value = "SysUser对象", description = "用户")
@Getter
@Setter
@ToString
public class SysUser extends Model<SysUser> {

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "昵称")
	private String nickName;

	@ApiModelProperty(value = "用户名")
	private String username;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "身份证号")
	private String idCard;

	@ApiModelProperty(value = "头像")
	private String avatar;

	@ApiModelProperty(value = "性别")
	private Integer sex;

	@ApiModelProperty(value = "电子邮箱")
	private String email;

	@ApiModelProperty(value = "手机号")
	private String phone;

	@ApiModelProperty(value = "状态")
	private Integer state;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateTime;

	/**
	 * 获取主键值
	 * @return 主键值
	 */
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}