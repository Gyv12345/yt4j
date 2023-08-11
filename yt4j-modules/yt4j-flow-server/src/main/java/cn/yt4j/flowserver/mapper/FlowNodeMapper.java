package cn.yt4j.flowserver.mapper;

import cn.yt4j.flowserver.entity.FlowNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程节点(FlowNode)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-11 11:35:14
 */
@Mapper
public interface FlowNodeMapper extends BaseMapper<FlowNode> {

}
