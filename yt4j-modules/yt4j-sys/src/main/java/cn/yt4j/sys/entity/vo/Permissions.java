package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author gyv12
 */
@Data
public class Permissions {

    private String roleId;

    private String permissionId;

    private String permissionName;

    private String actions;

    private List<ActionEntitySet> actionEntitySet;

    private String actionList;

    private String dataAccess;
}
