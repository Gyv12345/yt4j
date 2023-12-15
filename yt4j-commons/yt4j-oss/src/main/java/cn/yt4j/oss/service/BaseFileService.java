package cn.yt4j.oss.service;

import cn.yt4j.oss.entity.FileUploadParam;

public interface BaseFileService {

	/**
	 * 检查是否存在bucket，如果是本地存储，则创建bucket 如果是云存储，则检查是否存在bucket，不存在直接报错
	 * @param bucketName 存储桶名称
	 */
	void checkBucket(String bucketName);

	/**
	 * 文件上传
	 * @param param
	 * @return
	 */
	String uploadFileUrl(FileUploadParam param);

	/**
	 * 文件下载
	 * @param pathAndName
	 * @return
	 */
	String downloadFileUrl(String pathAndName);

}
