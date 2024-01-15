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

    NO_APP_ID(11000, "请配置 app_id"),
    NO_APP_SECRET(11001, "请配置 app_secret"),
    NO_ACCESS_TOKEN(11002, "请配置 access_token"),
    NO_REFRESH_TOKEN(11003, "请配置 refresh_token"),
    NO_CONTACT_ID(11004, "请配置 contact_id"),
    NO_CONTACT_TOKEN(11005, "请配置 contact_token"),
    NO_CONTACT_TOKEN_SECRET(11006, "请配置 contact_token_secret"),
    ;

    private final int code;

    private final String message;
}
