package cn.yt4j.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 数据源表
 *
 * @author gyv12345@163.com
 */
@TableName(value = "gen_datasource")
@Data
@ToString
public class GenDatasource implements Serializable {

	@Serial
	private static final long serialVersionUID = 3926873376004557461L;

	/**
	 * ID
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 数据源名称
	 */
	private String name;

	/**
	 * 数据库连接
	 */
	private String url;

	/**
	 * 数据库用户名
	 */
	private String username;

	/**
	 * 数据库密码
	 */
	private String password;

	/**
	 * 数据库类型
	 */
	private String databaseType;

	/**
	 * 数据库名称
	 */
	private String databaseName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

}
