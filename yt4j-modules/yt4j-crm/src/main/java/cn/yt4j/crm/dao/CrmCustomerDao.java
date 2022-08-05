package cn.yt4j.crm.dao;

import cn.yt4j.crm.entity.CrmCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户表(CrmCustomer)表数据库访问层
 *
 * @author gyv12345@163.com
 * @since 2022-08-04 21:02:49
 */
@Mapper
public interface CrmCustomerDao extends BaseMapper<CrmCustomer> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrmCustomer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CrmCustomer> entities);

}

