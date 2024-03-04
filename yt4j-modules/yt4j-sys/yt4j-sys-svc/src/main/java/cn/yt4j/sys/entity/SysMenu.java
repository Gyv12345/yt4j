
package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 资源权限(SysMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-14 15:29:53
 */
@Data
public class SysMenu extends Model<SysMenu> {

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 菜单类型
	 */
	private Short type;

	/**
	 * 父级 ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long parentId;

	/**
	 * 名称
	 */
	private String label;

	/**
	 * 名称
	 */
	private String title;

	/**
	 * 权限
	 */
	private String permission;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 排序
	 */
	private Integer orderNo;

	/**
	 * 是否隐藏
	 */
	private Boolean hidden;

	/**
	 * 重定向
	 */
	private String redirect;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 内容
	 */
	private String component;

	/**
	 * 是否保持激活
	 */
	private Boolean keepalive;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}
