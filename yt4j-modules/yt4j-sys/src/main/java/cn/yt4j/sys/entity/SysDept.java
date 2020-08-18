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

/**
 * 部门(SysDept)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:50
 */
@ApiModel(value = "SysDept对象", description = "部门")
@Getter
@Setter
@ToString
public class SysDept extends Model<SysDept> {

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "父级ID")
	private Long parentId;

	@ApiModelProperty(value = "部门名称")
	private String name;

	@ApiModelProperty(value = "部门编码")
	private String code;

	@ApiModelProperty(value = "层级")
	private String level;

	@ApiModelProperty(value = "部门电话")
	private String telephone;

	@ApiModelProperty(value = "部门描述")
	private String remark;

	@ApiModelProperty(value = "部门位置")
	private String location;

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