package cn.yt4j.sys.mapper;

import cn.yt4j.sys.entity.SysConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统配置(SysConfig)表数据库访问层
 *
 * @author gyv12345@163.com
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfig> {

}
