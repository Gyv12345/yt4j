package cn.yt4j.security.util;

import cn.yt4j.security.model.Yt4jUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author shichenyang
 */
@UtilityClass
public class SecurityUtil {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     *  获取用户
     * @param authentication
     * @return MedicalUser 医疗平台用户
     */
    public Yt4jUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof Yt4jUser) {
            return (Yt4jUser) principal;
        }
        return null;
    }
    /**
     * 获取用户
     */
    public Yt4jUser getUser() {
        Authentication authentication = getAuthentication();
        return getUser(authentication);
    }

}
