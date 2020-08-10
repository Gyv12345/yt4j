package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色(SysRole)表实体类
 *
 * @author makejava
 * @since 2020-08-10 08:43:33
 */
@ApiModel(value = "SysRole对象", description = "角色")
@Getter
@Setter
@ToString
public class SysRole extends Model<SysRole> {

    @ApiModelProperty(value = "id", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "角色名称", example = "1")
    private String name;

    @ApiModelProperty(value = "角色标识", example = "1")
    private String code;

    @ApiModelProperty(value = "角色权限等级 1部门及下属部门所有信息 2本部门 3本人", example = "1")
    private Integer level;

    @ApiModelProperty(value = "状态", example = "1")
    private Integer state;

    @ApiModelProperty(value = "创建时间", example = "1")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间", example = "1")
    private LocalDateTime updateTime;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}