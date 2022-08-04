package cn.yt4j.crm.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 客户表(CrmCustomer)表实体类
 *
 * @author gyv12345@163.com
 * @since 2022-08-04 21:02:49
 */
@ApiModel(value = "CrmCustomer对象", description = "客户表")
@Getter
@Setter
@ToString
public class CrmCustomer extends Model<CrmCustomer> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Long id;
    /**
     * 客户名称
     */
    @ApiModelProperty("客户名称")
    private String customerName;
    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Long createUserId;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private Long updateUserId;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
    /**
     * 部门
     */
    @ApiModelProperty("部门")
    private Long deptId;


}

