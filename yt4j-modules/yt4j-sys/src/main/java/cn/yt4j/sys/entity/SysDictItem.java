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
 * (SysDictItem)表实体类
 *
 * @author makejava
 * @since 2020-08-18 16:44:07
 */
@ApiModel(value = "SysDictItem对象", description = "")
@Getter
@Setter
@ToString
public class SysDictItem extends Model<SysDictItem> {

	@ApiModelProperty(value = "id", example = "1")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "字典编码", example = "1")
	private String code;

	@ApiModelProperty(value = "标题", example = "1")
	private String label;

	@ApiModelProperty(value = "值", example = "1")
	private String value;

	@ApiModelProperty(value = "创建时间", example = "1")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "修改时间", example = "1")
	private LocalDateTime updateTime;


}
