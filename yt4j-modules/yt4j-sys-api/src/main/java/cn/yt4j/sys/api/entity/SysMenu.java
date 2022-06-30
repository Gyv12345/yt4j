/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 资源权限(SysMenu)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-14 15:29:53
 */
@Getter
@Setter
@ToString
public class SysMenu extends Model<SysMenu> {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	private Short type;

	private Long parentId;

	private String label;

	private String title;

	private String permission;

	private String icon;

	private String layer;

	private Integer orderNo;

	private Boolean hidden;

	private String redirect;

	private String path;

	private String component;

	private Boolean keepalive;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

}
