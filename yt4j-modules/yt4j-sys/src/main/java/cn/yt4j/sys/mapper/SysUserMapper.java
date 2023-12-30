
package cn.yt4j.sys.mapper;

import cn.yt4j.sys.api.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户(SysUser)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:43
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
