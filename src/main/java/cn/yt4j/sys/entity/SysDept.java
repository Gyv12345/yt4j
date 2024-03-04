package cn.yt4j.sys.entity;

import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门(SysDept)表实体类
 *
 * @author makejava
 * @since 2024-03-04 10:09:59
 */
@Data
@ToString
public class SysDept implements Serializable {
    @Serial
    private static final long serialVersionUID = -17122847518674801L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}

