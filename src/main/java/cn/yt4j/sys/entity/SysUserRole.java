package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * (SysUserRole)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:44:10
 */
@ApiModel(value = "SysUserRole对象", description = "")
@Getter
@Setter
@ToString
public class SysUserRole extends Model<SysUserRole> {

	private Long userId;

	private Long roleId;

}