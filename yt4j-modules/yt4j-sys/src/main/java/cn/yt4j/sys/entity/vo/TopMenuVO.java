package cn.yt4j.sys.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 应用信息
 *
 * @author gyv12
 */
@ApiModel(value = "应用", description = "")
@Data
public class TopMenuVO implements Serializable {
    private static final long serialVersionUID = 8628688151192898733L;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("Id")
    private Long id;
    @ApiModelProperty("路径")
    private String path;
}
