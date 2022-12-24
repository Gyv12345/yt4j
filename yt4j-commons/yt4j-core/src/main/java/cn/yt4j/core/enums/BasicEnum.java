package cn.yt4j.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gyv12345@163.com
 */
@AllArgsConstructor
@Getter
public enum BasicEnum {

    PARENT(0L,"顶级父级")
    ;
    private Long id;

    private String desc;
}
