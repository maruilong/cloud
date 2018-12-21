package com.xinyuan.web.controller;

import com.xinyuan.entity.User;
import com.xinyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created on 2018/1/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User user() {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User u = userService.findByUsername(userDetails.getUsername());

        System.out.println(u.toString());

        return u;

    }
}
