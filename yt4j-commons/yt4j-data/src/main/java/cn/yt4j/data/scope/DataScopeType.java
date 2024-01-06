package cn.yt4j.data.scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gyv12345@163.com
 */
@AllArgsConstructor
@Getter
public enum DataScopeType {

	/**
	 * 全部
	 */
	ALL(1, "全部"),
	/**
	 * 部门以及下属部门所有信息
	 */
	SUBORDINATE(2, "部门以及下属部门所有信息"),
	/**
	 * 本部门
	 */
	MY_DEPARTMENT(3, "本部门"),
	/**
	 * 本人
	 */
	MY_SELF(4, "本人"),;

	private final int code;

	private final String description;

	public static DataScopeType parse(int code) {
		for (DataScopeType value : DataScopeType.values()) {
			if (value.code == code) {
				return value;
			}
		}
		return MY_SELF;
	}

}
