package cn.yt4j.generate.service.impl;

import cn.yt4j.generate.entity.GenDatasource;
import cn.yt4j.generate.mapper.GenDatasourceMapper;
import cn.yt4j.generate.service.GenDatasourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author gyv12345@163.com
 * @description 针对表【gen_datasource(数据源表)】的数据库操作Service实现
 * @createDate 2023-03-28 09:19:28
 */
@Service
public class GenDatasourceServiceImpl extends ServiceImpl<GenDatasourceMapper, GenDatasource>
		implements GenDatasourceService {

}
