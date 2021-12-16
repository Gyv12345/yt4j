/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 资源权限(SysMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-14 15:29:53
 */
@ApiModel(value = "SysMenu对象", description = "资源权限")
@Getter
@Setter
@ToString
public class SysMenu extends Model<SysMenu> {

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "类型 1系统 2菜单 3按钮")
	private Short type;

	@ApiModelProperty(value = "父级ID")
	private Long parentId;

	@ApiModelProperty(value = "路由名称 不能重复")
	private String label;

	@ApiModelProperty(value = "路由标题")
	private String title;

	@ApiModelProperty(value = "权限标识")
	private String permission;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "层级")
	private String layer;

	@ApiModelProperty(value = "排序")
	private Integer orderNo;

	@ApiModelProperty(value = "是否显示在左侧")
	private Boolean hidden;

	@ApiModelProperty("重定向")
	private String redirect;

	@ApiModelProperty(value = "请求地址")
	private String path;

	@ApiModelProperty(value = "组件地址")
	private String component;

	@ApiModelProperty(value = "缓存")
	private Boolean keepalive;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateTime;


}
