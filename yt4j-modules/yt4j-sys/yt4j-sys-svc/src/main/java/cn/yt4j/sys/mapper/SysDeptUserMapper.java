package cn.yt4j.sys.mapper;

import cn.yt4j.sys.entity.SysDeptUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门用户(SysDeptUser)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-04 10:04:40
 */
@Mapper
public interface SysDeptUserMapper extends BaseMapper<SysDeptUser> {

}

