package cn.yt4j.sys.service;

import cn.yt4j.sys.api.entity.SysOssFile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dromara.x.file.storage.core.recorder.FileRecorder;

/**
 * 文件记录表(SysOssFile)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2023-12-18 22:19:48
 */
public interface SysOssFileService extends IService<SysOssFile>, FileRecorder {

}
