package cn.yt4j.flowserver.service.impl;

import cn.yt4j.flowserver.entity.FlowInfo;
import cn.yt4j.flowserver.mapper.FlowInfoMapper;
import cn.yt4j.flowserver.service.FlowInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 流程信息(FlowInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-08-11 11:26:43
 */
@Service
public class FlowInfoServiceImpl extends ServiceImpl<FlowInfoMapper, FlowInfo> implements FlowInfoService {

}
