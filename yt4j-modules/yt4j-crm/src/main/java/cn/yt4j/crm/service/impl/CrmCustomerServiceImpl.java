package cn.yt4j.crm.service.impl;

import cn.yt4j.crm.entity.CrmCustomer;
import cn.yt4j.crm.mapper.CrmCustomerMapper;
import cn.yt4j.crm.service.CrmCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 客户表(CrmCustomer)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2023-11-30 14:55:37
 */
@Service
public class CrmCustomerServiceImpl extends ServiceImpl<CrmCustomerMapper, CrmCustomer> implements CrmCustomerService {

}
