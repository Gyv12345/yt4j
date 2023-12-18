package cn.yt4j.flowserver.service.impl;

import cn.yt4j.flowserver.entity.FlowNode;
import cn.yt4j.flowserver.mapper.FlowNodeMapper;
import cn.yt4j.flowserver.service.FlowNodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 流程节点(FlowNode)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2023-08-11 11:35:14
 */
@Service
public class FlowNodeServiceImpl extends ServiceImpl<FlowNodeMapper, FlowNode> implements FlowNodeService {

}
