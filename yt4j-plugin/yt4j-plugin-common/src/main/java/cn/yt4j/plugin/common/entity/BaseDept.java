package cn.yt4j.plugin.common.entity;

import lombok.Data;

/**
 * 基本部门
 * @author gyv12345@163.com
 */
@Data
public class BaseDept {

   private String name;

   private String parentId;

   private String deptId;

   private String order;
}
