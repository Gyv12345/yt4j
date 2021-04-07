/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
public class Role implements Serializable {

	private static final long serialVersionUID = 8333219920882065467L;

	private String id;

	private String name;

	private String describe;

	private int status;

	private String creatorId;

	private int createTime;

	private int deleted;

	private List<Permissions> permissions;

}
