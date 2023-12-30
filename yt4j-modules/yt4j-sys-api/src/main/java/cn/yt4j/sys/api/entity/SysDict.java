
package cn.yt4j.sys.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 字典(SysDict)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:31
 */
@Data
@ToString
public class SysDict implements Serializable {

	@Serial
	private static final long serialVersionUID = -6175933080635511813L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 字典编码
	 */
	private String code;

	/**
	 * 字典名称
	 */
	private String name;

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

	@NotNull
	@TableField(exist = false)
	private List<SysDictItem> items;

}
