
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
 * (SysDictItem)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-18 16:44:07
 */
@Getter
@Setter
@ToString
public class SysDictItem extends Model<SysDictItem> {

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
