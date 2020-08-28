package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
/**
 * @author gyv12345@163.com
 */
@Data
public class DictVO implements Serializable {
    private static final long serialVersionUID = -7694822691794776892L;

    private String label;

    private String value;
}
