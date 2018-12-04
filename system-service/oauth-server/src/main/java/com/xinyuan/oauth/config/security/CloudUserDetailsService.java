package com.xinyuan.oauth.config.security;

import com.xinyuan.oauth.service.UserService;
import com.xinyuan.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created on 2017/12/26.
 *
 * @author zlf
 * @since 1.0
 */
@Component
public class CloudUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO userDTO = userService.findByUserName(username);

        if (userDTO == null) {
            throw new UsernameNotFoundException("用户名：" + username + "不存在或已禁用！");
        } else if (userDTO.getStatus() == 2 || userDTO.getDeleted() == 1) {
            throw new UsernameNotFoundException("用户名：" + username + "不存在或已禁用！");
        }

        Collection<SimpleGrantedAuthority> collection = new HashSet<>();

        Iterator<String> iterator = userService.findRoles(userDTO.getId()).iterator();
        while (iterator.hasNext()) {
            collection.add(new SimpleGrantedAuthority(iterator.next()));
        }
        return new org.springframework.security.core.userdetails.User(username, passwordEncoder.encode(userDTO.getPassword()), collection);
    }
}
