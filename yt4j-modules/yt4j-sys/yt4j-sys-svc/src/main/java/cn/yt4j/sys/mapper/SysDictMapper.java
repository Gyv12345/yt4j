
package cn.yt4j.sys.mapper;

import cn.yt4j.sys.entity.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典(SysDict)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:31
 */
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {

}
