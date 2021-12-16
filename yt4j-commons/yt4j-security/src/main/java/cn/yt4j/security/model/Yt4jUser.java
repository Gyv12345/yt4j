/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
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
