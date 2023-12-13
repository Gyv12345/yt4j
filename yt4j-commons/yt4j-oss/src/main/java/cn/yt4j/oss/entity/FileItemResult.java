package cn.yt4j.oss.entity;

import cn.hutool.core.util.StrUtil;
import cn.yt4j.oss.enums.FileTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件信息结果类
 *
 * @author zhaojun
 */
@Data
@ToString
public class FileItemResult implements Serializable {
    /**
     * 文件名
     */
    private String name;
    /**
     * 时间
     */
    private LocalDateTime time;
    /**
     * 大小
     */
    private Long size;
    /**
     * 类型
     */
    private FileTypeEnum type;
    /**
     * 路径
     */
    private String path;
    /**
     * 下载地址
     */
    private String url;

    /**
     * 获取路径和名称的组合, 并移除重复的路径分隔符 /.
     *
     * @return  路径和名称的组合
     */
    @JsonIgnore
    public String getFullPath() {
        return StrUtil.concat(false,path, name);
    }

}
