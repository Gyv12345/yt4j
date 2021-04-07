/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.security.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Data
public class UserCache implements Serializable {

	private static final long serialVersionUID = 5164200545222533394L;

	private Long id;

	private String username;

	private String password;

	private String nickName;

	private List<String> roles;

	private List<String> menus;

}
