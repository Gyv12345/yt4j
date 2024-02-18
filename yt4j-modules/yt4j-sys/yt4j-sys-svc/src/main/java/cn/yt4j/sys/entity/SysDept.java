
package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 部门(SysDept)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:50
 */
@Getter
@Setter
@ToString
@Schema(name = "SysDept", description = "部门")
public class SysDept extends Model<SysDept> {

	/**
	 * 主键
	 */
	@Schema(name = "id", description = "主键")
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 父级ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long parentId;

	/**
	 * 部门名称
	 */
	private String label;

	/**
	 * 排序
	 */
	private Integer orderNo;

	/**
	 * 状态
	 */
	private Integer state;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}
