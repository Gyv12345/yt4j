package cn.yt4j.sys.api.entity.vo;

import cn.yt4j.sys.api.entity.SysConfig;
import io.github.linpeilie.annotations.AutoMapper;
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
@AutoMapper(target = SysConfig.class)
public class SysConfigVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 105694738567100570L;

	/**
	 * ID
	 */
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
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}
