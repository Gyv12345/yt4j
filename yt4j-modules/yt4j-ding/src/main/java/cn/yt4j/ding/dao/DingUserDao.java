package cn.yt4j.ding.dao;

import cn.yt4j.ding.entity.DingUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 钉钉的用户(DingUser)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2021-01-15 08:38:42
 */
@Mapper
public interface DingUserDao extends BaseMapper<DingUser> {

}
