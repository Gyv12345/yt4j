package cn.yt4j.security.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author shichenyang
 */
public class Yt4jUser extends User implements Serializable {

    private static final long serialVersionUID = 8350468759914530189L;
    @Getter
    private Long id;

    @Getter
    @Setter
    private String realName;

    @Getter
    private Long positionId;

    @Getter
    private String deptCode;

    @Getter
    private String deptName;

    @Getter
    private Integer level;

    public Yt4jUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, Long positionId, String deptCode, String deptName, Integer level) {
        super(username, password, authorities);
        this.id=id;
        this.positionId=positionId;
        this.deptCode=deptCode;
        this.deptName=deptName;
        this.level=level;
    }
}
