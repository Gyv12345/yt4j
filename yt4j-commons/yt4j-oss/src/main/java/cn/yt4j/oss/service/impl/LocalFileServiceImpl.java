package cn.yt4j.oss.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.yt4j.oss.entity.FileUploadParam;
import cn.yt4j.oss.property.FileProperty;
import cn.yt4j.oss.service.BaseFileService;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author gyv1234@163.com
 */
@Slf4j
public class LocalFileServiceImpl implements BaseFileService {

    private FileProperty fileProperty;

    @Override
    public void checkBucket(String bucketName) {
        log.info("检查bucket:{}", bucketName);
        if (!FileUtil.isDirectory(fileProperty.getBasePath() + File.separator + fileProperty.getBucketName())) {
            FileUtil.mkdir(fileProperty.getBasePath() + File.separator + fileProperty.getBucketName());
        }
    }

    @Override
    public String uploadFileUrl(FileUploadParam param) {
        return fileProperty.getDomain()+"/upload";
    }

    @Override
    public String downloadFileUrl(String pathAndName) {
        return fileProperty.getDomain()+"/download";
    }
}
