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
 * 字典(SysDict)表实体类
 *
 * @author makejava
 * @since 2020-08-10 08:43:31
 */
@ApiModel(value = "SysDict对象", description = "字典")
@Getter
@Setter
@ToString
public class SysDict extends Model<SysDict> {

    @ApiModelProperty(value = "id", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "字典关键字", example = "1")
    private String code;

    @ApiModelProperty(value = "字典名称", example = "1")
    private String name;

    @ApiModelProperty(value = "字典值", example = "1")
    private String value;

    @ApiModelProperty(value = "父字典", example = "1")
    private Long parentId;

    @ApiModelProperty(value = "状态", example = "1")
    private Integer state;

    @ApiModelProperty(value = "用户类型 0 系统 1 用户", example = "1")
    private Integer type;

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