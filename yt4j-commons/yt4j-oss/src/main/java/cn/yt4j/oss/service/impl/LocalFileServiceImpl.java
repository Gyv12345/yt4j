package cn.yt4j.oss.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.yt4j.oss.entity.FileUploadParam;
import cn.yt4j.oss.service.BaseFileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalFileServiceImpl implements BaseFileService {

    @Override
    public void checkBucket(String bucketName) {
        log.info("检查bucket:{}",bucketName);
        if (FileUtil.isEmpty()){

        }
    }

    @Override
    public String uploadFileUrl(FileUploadParam param) {
        return null;
    }

    @Override
    public String downloadFileUrl(String pathAndName) {
        return null;
    }
}
