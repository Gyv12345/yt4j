package cn.yt4j.data.scope;

import lombok.*;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class DataScope implements Serializable {

	private static final long serialVersionUID = 5797127798849230892L;

	/**
	 * 表别名
	 */
	private String alias;
	/**
	 * 数据权限列名
	 */
	private String columnName;

}
