/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.security.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author gyv12345@163.com
 */
public class Yt4jUser extends User implements Serializable {

	private static final long serialVersionUID = 8350468759914530189L;

	@Getter
	private Long id;

	@JsonCreator
	public Yt4jUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id) {
		super(username, password, authorities);
		this.id = id;
	}

}
