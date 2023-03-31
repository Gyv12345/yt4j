package cn.yt4j.generate.mapper;

import cn.yt4j.generate.entity.GenTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gyv12345@163.com
 * @description 针对表【gen_table(代码生成业务表)】的数据库操作Mapper
 * @createDate 2023-03-28 09:38:00
 * @Entity generator.entity.GenTable
 */
@Mapper
public interface GenTableMapper extends BaseMapper<GenTable> {

}
