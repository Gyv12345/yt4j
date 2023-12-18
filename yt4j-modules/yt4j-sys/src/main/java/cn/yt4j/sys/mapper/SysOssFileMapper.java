package cn.yt4j.sys.mapper;

import cn.yt4j.sys.api.entity.SysOssFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件记录表(SysOssFile)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2023-12-18 22:19:46
 */
@Mapper
public interface SysOssFileMapper extends BaseMapper<SysOssFile> {

}
