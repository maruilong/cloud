package com.xinyuan.config.security;

import com.xinyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created on 2017/12/26.
 *
 * @author zlf
 * @since 1.0
 */
@Component
public class SsoUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User user = userService.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名：" + username + "不存在或已禁用！");
//        } else if (user.getStatus() == 2 || user.getDeleted() == 1) {
//            throw new UsernameNotFoundException("用户名：" + username + "不存在或已禁用！");
//        }
//
//        userService.updateUser(user);
//
//        Collection<SimpleGrantedAuthority> collection = new HashSet<>();

//        Iterator<String> iterator = userRoleService.findRoles(user.getId()).iterator();
//        while (iterator.hasNext()) {
//            collection.add(new SimpleGrantedAuthority(iterator.next()));
//        }

        return new org.springframework.security.core.userdetails.User(username, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));


    }
}
