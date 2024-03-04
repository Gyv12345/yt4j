package cn.yt4j.sys.entity.vo;

import cn.yt4j.sys.entity.SysDept;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门(SysDept)表实体类
 *
 * @author makejava
 * @since 2024-03-04 10:10:00
 */
@Data
@ToString
@AutoMapper(target = SysDept.class)
public class SysDeptVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -61643406804879536L;

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

