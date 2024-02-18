
package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色权限(SysRoleMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:09
 */
@Getter
@Setter
@ToString
public class SysRoleMenu extends Model<SysRoleMenu> {

	/**
	 * 角色ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long menuId;

}
