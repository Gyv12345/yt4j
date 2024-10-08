package cn.yt4j.feishu.common;

import cn.yt4j.core.enums.IMessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shichenyang
 */
@AllArgsConstructor
@Getter
public enum FeiShuCodeEnum implements IMessageStatus {

	/**
	 * appid需要填写
	 */
	NO_APP_ID(11000, "请配置 app_id"),
	/**
	 * secret需要填写
	 */
	NO_APP_SECRET(11001, "请配置 app_secret"),
	/**
	 * access_token需要填写
	 */
	NO_ACCESS_TOKEN(11002, "请配置 access_token"),;

	private final int code;

	private final String message;

}
