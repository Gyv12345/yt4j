package cn.yt4j.core.sensitive;

/**
 * 敏感信息枚举类
 *
 * @author mayee
 * @version v1.0
 **/
public enum SensitiveTypeEnum {

    /**
     * 自定义
     */
    CUSTOMER,
    /**
     * 用户名, 刘*华, 徐*
     */
    CHINESE_NAME,
    /**
     * 身份证号, 110110********1234
     */
    ID_CARD,
    /**
     * 座机号, ****1234
     */
    FIXED_PHONE,
    /**
     * 手机号, 176****1234
     */
    MOBILE_PHONE,
    /**
     * 地址, 北京********
     */
    ADDRESS,
    /**
     * 电子邮件, s*****o@xx.com
     */
    EMAIL,
    /**
     * 银行卡, 622202************1234
     */
    BANK_CARD,
    /**
     * 密码, 永远是 ******, 与长度无关
     */
    PASSWORD,
    /**
     * 密钥, 永远是 ******, 与长度无关
     */
    KEY


}
