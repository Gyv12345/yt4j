package cn.yt4j.sys.api.entity.dto;

import cn.yt4j.sys.api.entity.SysDept;
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
 * @since 2023-11-29 12:07:35
 */
@Data
@ToString
@AutoMapper(target = SysDept.class, reverseConvertGenerate = false)
public class SysDeptDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -80802246559128206L;

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
    private String label;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}

