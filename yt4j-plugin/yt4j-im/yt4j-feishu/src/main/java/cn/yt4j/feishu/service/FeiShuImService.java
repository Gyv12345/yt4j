package cn.yt4j.feishu.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.yt4j.im.client.BaseImClient;
import cn.yt4j.im.constant.ImConstants;
import cn.yt4j.im.entity.BaseDept;
import cn.yt4j.im.entity.BaseUser;
import com.lark.oapi.Client;
import com.lark.oapi.service.contact.v3.model.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 飞书通讯录服务
 *
 * @author gyv12345@163.com
 */
@Service
@RequiredArgsConstructor
public class FeiShuImService implements BaseImClient {

	private final Client client;

	@Override
	public String check() {
		return ImConstants.FEISHU_PARENT_ID;
	}

	@Override
	@SneakyThrows
	public List<BaseDept> getDept(String deptId) {
		List<Department> allDept = new ArrayList<>();
		recursionDept(allDept, deptId, null);

		return allDept.stream().map(dept -> {
			BaseDept baseDept = new BaseDept();
			baseDept.setName(dept.getName());
			baseDept.setDeptId(dept.getDepartmentId());
			baseDept.setOrder(dept.getOrder());

			return baseDept;
		}).collect(Collectors.toList());
	}

	@SneakyThrows
	private void recursionDept(List<Department> allDept, String deptId, String pageToken) {
		// 创建请求对象
		ChildrenDepartmentReq req = ChildrenDepartmentReq.newBuilder()
			.userIdType("open_id")
			.departmentIdType("open_department_id")
			.pageSize(50)
			.departmentId(deptId)
			.pageToken(pageToken)
			.build();

		// 发起请求
		ChildrenDepartmentResp resp = client.contact().department().children(req);

		if (resp.success()) {
			if (CollectionUtil.isNotEmpty(Arrays.asList(resp.getData().getItems()))) {
				allDept.addAll(List.of(resp.getData().getItems()));
			}
			if (resp.getData().getHasMore()) {
				recursionDept(allDept, deptId, resp.getData().getPageToken());
			}
		}
	}

	@Override
	public List<BaseUser> getUser(String deptId) {
		List<User> allUser = new ArrayList<>();
		recursionUser(allUser, deptId, null);
		return allUser.stream().map(item -> {
			BaseUser baseUser = new BaseUser();
			baseUser.setName(item.getName());
			baseUser.setLeader(item.getLeaderUserId());
			baseUser.setGender(item.getGender().toString());
			baseUser.setOpenId(item.getOpenId());
			return baseUser;

		}).collect(Collectors.toList());
	}

	@SneakyThrows
	private void recursionUser(List<User> allUser, String deptId, String pageToken) {
		// 创建请求对象
		FindByDepartmentUserReq req = FindByDepartmentUserReq.newBuilder()
			.userIdType("open_id")
			.pageSize(50)
			.departmentId(deptId)
			.departmentId("0")
			.departmentIdType("open_department_id")
			.pageToken(pageToken)
			.build();

		// 发起请求
		FindByDepartmentUserResp resp = client.contact().user().findByDepartment(req);

		if (resp.success()) {
			if (CollectionUtil.isNotEmpty(Arrays.asList(resp.getData().getItems()))) {
				allUser.addAll(List.of(resp.getData().getItems()));
			}
			if (resp.getData().getHasMore()) {
				recursionUser(allUser, deptId, resp.getData().getPageToken());
			}
		}
	}

}
