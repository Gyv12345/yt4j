package cn.yt4j.sys.entity.dto;

import lombok.Data;
import lombok.ToString;
import cn.yt4j.sys.entity.SysDept;
import io.github.linpeilie.annotations.AutoMapper;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门(SysDept)表实体类
 *
 * @author makejava
 * @since 2024-03-04 10:09:55
 */
@Data
@ToString
@AutoMapper(target = SysDept.class, reverseConvertGenerate = false)
public class SysDeptDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 444488828097154558L;

    /**
     * id
     */
    private Long id;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 第三方部门ID
     */
    private String departmentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}

