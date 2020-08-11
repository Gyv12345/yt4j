package cn.yt4j.sys.dao;

import cn.yt4j.sys.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 角色(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-10 08:43:34
 */
public interface SysRoleDao extends BaseMapper<SysRole> {
    /**
     * 获取用户所有角色信息
     * @param id
     * @return
     */
    List<String> listByUserId(Long id);

}