
package cn.yt4j.sys.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 资源权限(SysMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-14 15:29:53
 */
@Getter
@Setter
@ToString
public class SysMenu extends Model<SysMenu> {

	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	private Short type;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long parentId;

	private String label;

	private String title;

	private String permission;

	private String icon;

	private Integer orderNo;

	private Boolean hidden;

	private String redirect;

	private String path;

	private String component;

	private Boolean keepalive;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

}
