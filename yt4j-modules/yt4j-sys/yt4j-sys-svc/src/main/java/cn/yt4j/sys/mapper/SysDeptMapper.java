
package cn.yt4j.sys.mapper;

import cn.yt4j.sys.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门(SysDept)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:51
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

}
