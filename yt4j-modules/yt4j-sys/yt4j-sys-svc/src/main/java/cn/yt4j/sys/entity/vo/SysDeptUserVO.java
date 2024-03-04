package cn.yt4j.sys.entity.vo;

import cn.yt4j.sys.entity.SysDeptUser;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门用户(SysDeptUser)表实体类
 *
 * @author makejava
 * @since 2024-03-04 10:04:42
 */
@Data
@ToString
@AutoMapper(target = SysDeptUser.class)
public class SysDeptUserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 743155944838774251L;

    /**
     * ID
     */
    private Long id;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}

