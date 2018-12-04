package com.xinyuan.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 2018/1/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        User u = userService.findByUsername(userDetails.getUsername());
//
//        System.out.println(u.toString());
//
//        return u;

        return principal;
    }
}
