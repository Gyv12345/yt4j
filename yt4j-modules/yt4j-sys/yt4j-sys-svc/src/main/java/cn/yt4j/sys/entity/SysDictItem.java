
package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (SysDictItem)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-18 16:44:07
 */
@Data
public class SysDictItem implements Serializable {

	@Serial
	private static final long serialVersionUID = 1623449844905109580L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 名称
	 */
	private String label;

	/**
	 * 值
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
