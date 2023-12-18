package cn.yt4j.sys.entity.vo;

import cn.yt4j.sys.api.entity.SysOssFile;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件记录表(SysOssFile)表实体类
 *
 * @author makejava
 * @since 2023-12-18 22:19:48
 */
@Data
@ToString
@AutoMapper(target = SysOssFile.class)
public class SysOssFileVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -26211491085080528L;

    /**
     * 文件id
     */
    private Long id;

    /**
     * 文件访问地址
     */
    private String url;

    /**
     * 文件大小，单位字节
     */
    private Long size;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 原始文件名
     */
    private String originalFilename;

    /**
     * 基础存储路径
     */
    private String basePath;

    /**
     * 存储路径
     */
    private String path;

    /**
     * 文件扩展名
     */
    private String ext;

    /**
     * MIME类型
     */
    private String contentType;

    /**
     * 存储平台
     */
    private String platform;

    /**
     * 缩略图访问路径
     */
    private String thUrl;

    /**
     * 缩略图名称
     */
    private String thFilename;

    /**
     * 缩略图大小，单位字节
     */
    private Long thSize;

    /**
     * 缩略图MIME类型
     */
    private String thContentType;

    /**
     * 文件所属对象id
     */
    private String objectId;

    /**
     * 文件所属对象类型，例如用户头像，评价图片
     */
    private String objectType;

    /**
     * 文件元数据
     */
    private String metadata;

    /**
     * 文件用户元数据
     */
    private String userMetadata;

    /**
     * 缩略图元数据
     */
    private String thMetadata;

    /**
     * 缩略图用户元数据
     */
    private String thUserMetadata;

    /**
     * 附加属性
     */
    private String attr;

    /**
     * 文件ACL
     */
    private String fileAcl;

    /**
     * 缩略图文件ACL
     */
    private String thFileAcl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}

