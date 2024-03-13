
package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色(SysRole)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:33
 */
@Data
public class SysRole implements Serializable {

	@Serial
	private static final long serialVersionUID = 7673599942232273069L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 角色编码
	 */
	private String code;

	/**
	 * 权限等级
	 */
	private Integer level;

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
