package cn.yt4j.ding.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 部门职位(DingDeptTitle)表实体类
 *
 * @author gyv12345@163.com
 * @since 2021-02-19 11:42:32
 */
@ApiModel(value = "DingDeptTitle对象", description = "部门职位")
@Getter
@Setter
@ToString
public class DingDeptTitle extends Model<DingDeptTitle> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "部门ID。")
    private Integer deptId;

    @ApiModelProperty(value = "员工在部门中的职位。")
    private String title;


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
