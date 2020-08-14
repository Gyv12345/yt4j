package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 8333219920882065467L;
    private String id;

    private String name;

    private String describe;

    private int status;

    private String creatorId;

    private int createTime;

    private int deleted;

    private List<Permissions> permissions;

}
