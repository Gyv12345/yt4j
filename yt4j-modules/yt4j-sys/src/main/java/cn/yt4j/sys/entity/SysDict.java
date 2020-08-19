package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 字典(SysDict)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:31
 */
@ApiModel(value = "SysDict对象", description = "字典")
@Getter
@Setter
@ToString
public class SysDict extends Model<SysDict> {

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "字典关键字")
	private String code;

	@ApiModelProperty(value = "字典名称")
	private String name;

	@ApiModelProperty(value = "字典值")
	private String value;

	@ApiModelProperty(value = "父字典")
	private Long parentId;

	@ApiModelProperty(value = "状态")
	private Integer state;

	@ApiModelProperty(value = "用户类型 0 系统 1 用户")
	private Integer type;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateTime;

	@NotNull
	@TableField(exist = false)
	private List<SysDictItem> items;

	/**
	 * 获取主键值
	 * @return 主键值
	 */
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}