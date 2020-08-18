package cn.yt4j.sys.service;

import cn.yt4j.core.domain.BaseTree;
import cn.yt4j.sys.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 部门(SysDept)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:51
 */
public interface SysDeptService extends IService<SysDept> {

	List<BaseTree> treeDept();

}