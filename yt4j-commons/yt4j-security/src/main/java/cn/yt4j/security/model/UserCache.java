
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
