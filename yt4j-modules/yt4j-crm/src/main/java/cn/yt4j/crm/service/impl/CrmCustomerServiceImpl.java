package cn.yt4j.crm.service.impl;

import cn.yt4j.crm.dao.CrmCustomerDao;
import cn.yt4j.crm.entity.CrmCustomer;
import cn.yt4j.crm.service.CrmCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 客户表(CrmCustomer)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2022-08-04 21:02:52
 */
@Service("crmCustomerService")
public class CrmCustomerServiceImpl extends ServiceImpl<CrmCustomerDao, CrmCustomer> implements CrmCustomerService {

}
