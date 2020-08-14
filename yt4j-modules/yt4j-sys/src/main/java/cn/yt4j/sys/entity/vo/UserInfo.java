package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -7219556137655994917L;

    private String name;

    private String avatar;

    private Role role;
}
