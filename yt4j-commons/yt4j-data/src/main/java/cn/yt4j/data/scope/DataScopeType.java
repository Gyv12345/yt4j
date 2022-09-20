package cn.yt4j.data.scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gyv12345@163.com
 */
@AllArgsConstructor
@Getter
public enum DataScopeType {

	ALL(1, "全部"), SUBORDINATE(2, "部门以及下属部门所有信息"), MY_DEPARTMENT(3, "本部门"), MY_SELF(4, "本人"),;

	private int code;

	private String description;

	public static DataScopeType parse(int code) {
		for (DataScopeType value : DataScopeType.values()) {
			if (value.code == code) {
				return value;
			}
		}
		return null;
	}

}