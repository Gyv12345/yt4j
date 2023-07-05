
package cn.yt4j.sys.api.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * (SysUserRole)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:10
 */
@Getter
@Setter
@ToString
public class SysUserRole extends Model<SysUserRole> {

	/**
	 * 用户ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long userId;

	/**
	 * 角色ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long roleId;

}
