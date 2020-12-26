
package com.alibaba.nacos.console.security;


import com.alibaba.nacos.config.server.model.User;
import com.alibaba.nacos.config.server.service.PersistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custem user service
 *
 * @author wfnuser
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private transient PersistService persistService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = persistService.findUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new CustomUserDetails(user);
    }

    public void updateUserPassword(String username, String password) throws Exception {
        persistService.updateUserPassword(username, password);
    }
}
