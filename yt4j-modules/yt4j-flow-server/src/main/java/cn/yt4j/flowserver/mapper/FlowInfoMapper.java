package cn.yt4j.flowserver.mapper;

import cn.yt4j.flowserver.entity.FlowInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程信息(FlowInfo)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2023-08-11 11:26:40
 */
@Mapper
public interface FlowInfoMapper extends BaseMapper<FlowInfo> {

}
