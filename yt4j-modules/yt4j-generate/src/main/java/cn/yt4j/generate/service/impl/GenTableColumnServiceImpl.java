package cn.yt4j.generate.service.impl;

import cn.yt4j.generate.entity.GenTableColumn;
import cn.yt4j.generate.mapper.GenTableColumnMapper;
import cn.yt4j.generate.service.GenTableColumnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author gyv12345@163.com
 * @description 针对表【gen_table_column(代码生成业务表字段)】的数据库操作Service实现
 * @createDate 2023-03-28 09:38:00
 */
@Service
public class GenTableColumnServiceImpl extends ServiceImpl<GenTableColumnMapper, GenTableColumn>
		implements GenTableColumnService {

}
