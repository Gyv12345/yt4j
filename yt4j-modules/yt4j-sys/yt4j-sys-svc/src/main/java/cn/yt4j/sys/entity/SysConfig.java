package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统配置(SysConfig)表实体类
 *
 * @author gyv12345@163.com
 * @since 2024-01-06 15:00:25
 */
@Data
@ToString
public class SysConfig implements Serializable {

	@Serial
	private static final long serialVersionUID = -47221997911659751L;

	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 配置名称
	 */
	private String name;

	/**
	 * 配置key
	 */
	private String key;

	/**
	 * 配置值
	 */
	private String value;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime updateTime;

}
