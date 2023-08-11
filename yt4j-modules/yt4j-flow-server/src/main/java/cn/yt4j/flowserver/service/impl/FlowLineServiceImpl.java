package cn.yt4j.flowserver.service.impl;

import cn.yt4j.flowserver.entity.FlowLine;
import cn.yt4j.flowserver.mapper.FlowLineMapper;
import cn.yt4j.flowserver.service.FlowLineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 流程连线(FlowLine)表服务实现类
 *
 * @author makejava
 * @since 2023-08-11 11:35:14
 */
@Service
public class FlowLineServiceImpl extends ServiceImpl<FlowLineMapper, FlowLine> implements FlowLineService {

}
