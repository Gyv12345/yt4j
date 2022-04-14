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

import cn.yt4j.core.sensitive.Sensitive;
import cn.yt4j.core.sensitive.SensitiveTypeEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户(SysUser)表实体类
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:42
 */
@Getter
@Setter
@ToString
public class SysUser extends Model<SysUser> {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	private Long deptId;

	private String nickName;

	private String username;

	@JsonProperty
	private String password;

	@Sensitive(type = SensitiveTypeEnum.ID_CARD)
	private String idCard;

	private String avatar;

	private Integer sex;

	@Sensitive(type = SensitiveTypeEnum.EMAIL)
	private String email;

	@Sensitive(type = SensitiveTypeEnum.MOBILE_PHONE)
	private String phone;

	private Boolean state;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	@TableField(exist = false)
	private List<Long> roleIds;

}
