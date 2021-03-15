package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色权限(SysRoleMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:09
 */
@ApiModel(value = "SysRoleMenu对象", description = "角色权限")
@Getter
@Setter
@ToString
public class SysRoleMenu extends Model<SysRoleMenu> {

	@ApiModelProperty(value = "角色ID")
	private Long roleId;

	@ApiModelProperty(value = "权限ID")
	private Long menuId;

}