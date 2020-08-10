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
 * 部门(SysDept)表实体类
 *
 * @author makejava
 * @since 2020-08-10 08:43:50
 */
@ApiModel(value = "SysDept对象", description = "部门")
@Getter
@Setter
@ToString
public class SysDept extends Model<SysDept> {

    @ApiModelProperty(value = "id", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父级ID", example = "1")
    private Long parentId;

    @ApiModelProperty(value = "部门名称", example = "1")
    private String name;

    @ApiModelProperty(value = "部门编码", example = "1")
    private String code;

    @ApiModelProperty(value = "层级", example = "1")
    private String level;

    @ApiModelProperty(value = "部门电话", example = "1")
    private String telephone;

    @ApiModelProperty(value = "部门描述", example = "1")
    private String remark;

    @ApiModelProperty(value = "部门位置", example = "1")
    private String location;

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