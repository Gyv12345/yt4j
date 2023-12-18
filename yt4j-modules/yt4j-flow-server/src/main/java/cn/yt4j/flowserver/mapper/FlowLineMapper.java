package cn.yt4j.flowserver.mapper;

import cn.yt4j.flowserver.entity.FlowLine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程连线(FlowLine)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2023-08-11 11:35:12
 */
@Mapper
public interface FlowLineMapper extends BaseMapper<FlowLine> {

}
