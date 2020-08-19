package cn.yt4j.sys.service;

import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.entity.dto.RoleMenuDTO;
import cn.yt4j.sys.entity.vo.DictVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色(SysRole)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-10 08:43:34
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * 设置角色权限
	 * @param dto
	 * @return
	 */
	Boolean setting(RoleMenuDTO dto);

	/**
	 * 批量获取已经选中的权限
	 * @param id
	 * @return
	 */
	List<Long> listMenuIds(Long id);

	/**
	 *
	 * @return
	 */
	List<DictVO> dropDown();

}