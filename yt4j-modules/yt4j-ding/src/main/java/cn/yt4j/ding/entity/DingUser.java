package cn.yt4j.ding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 钉钉的用户(DingUser)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-12-24 11:36:30
 */
@ApiModel(value = "DingUser对象", description = "钉钉的用户")
@Getter
@Setter
@ToString
public class DingUser extends Model<DingUser> {

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty(value = "员工唯一标识ID（不可修改），企业内必须唯一。长度为1~64个字符，如果不传，将自动生成一个userid。")
	private String userid;

	@ApiModelProperty(value = "员工姓名，长度最大64个字符。")
	private String name;

	@ApiModelProperty(value = "手机号码，企业内必须唯一，不可重复。如果是国际号码，请使用+xx-xxxxxx的格式。")
	private String mobile;

	@ApiModelProperty(value = "是否号码隐藏： true：隐藏隐藏手机号后，手机号在个人资料页隐藏，但仍可对其发DING、发起钉钉免费商务电话。 false：不隐藏")
	private Short hideMobile;

	@ApiModelProperty(value = "分机号，长度最大50个字符。企业内必须唯一，不可重复。")
	private String telephone;

	@ApiModelProperty(value = "员工工号，长度最大为64个字符。")
	private String jobNumber;

	@ApiModelProperty(value = "职位，长度最大为300个字符。")
	private String title;

	@ApiModelProperty(value = "员工邮箱，长度最大64个字符。企业内必须唯一，不可重复。")
	private String email;

	@ApiModelProperty(value = "员工的企业邮箱，员工的企业邮箱已开通，才能增加此字段。")
	private String orgEmail;

	@ApiModelProperty(value = "办公地点，长度最大为50个字符。")
	private String workPlace;

	@ApiModelProperty(value = "备注，长度最大为1024个字符。")
	private String remark;

	@ApiModelProperty(value = "所属部门ID列表，多个部门ID之间用逗号分割。")
	private String deptIdList;

	@ApiModelProperty(
			value = "扩展属性，可以设置多种属性，在使用该参数前，需要先在OA管理后台增加该属性，然后再调用接口进行赋值。详情请参见关于extension参数的使用。手机上最多只能显示10个扩展属性。该字段的值支持链接类型填写，同时链接支持变量通配符自动替换，目前支持通配符有：userid，corpid。示例： [工位地址](http://www.dingtalk.com?userid=#userid#&corpid=#corpid#)。")
	private String extension;

	@ApiModelProperty(value = "是否开启高管模式： true：开启。开启后，手机号码对所有员工隐藏。普通员工无法对其发DING、发起钉钉免费商务电话。高管之间不受影响。 false：不开启。")
	private Short seniorMode;

	@ApiModelProperty(value = "入职时间，Unix时间戳，单位毫秒")
	private Long hiredDate;

	/**
	 * 获取主键值
	 * @return 主键值
	 */
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
