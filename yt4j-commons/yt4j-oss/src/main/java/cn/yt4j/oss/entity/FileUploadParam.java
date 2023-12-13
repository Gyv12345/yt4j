package cn.yt4j.oss.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文件上传参数
 */
@Data
@ToString
public class FileUploadParam implements Serializable {

    private static final long serialVersionUID = 2410794363869714416L;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件大小
     */
    private Long size;


}
