package cn.yt4j.crm.mapper;

import cn.yt4j.crm.entity.CrmCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户表(CrmCustomer)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-30 14:55:40
 */
@Mapper
public interface CrmCustomerMapper extends BaseMapper<CrmCustomer> {

}
