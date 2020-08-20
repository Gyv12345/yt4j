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
