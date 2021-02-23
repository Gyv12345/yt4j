package cn.yt4j.ding.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.yt4j.ding.entity.DingDeptTitle;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门职位(DingDeptTitle)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2021-02-19 11:42:32
 */
@Mapper
public interface DingDeptTitleDao extends BaseMapper<DingDeptTitle> {

}
