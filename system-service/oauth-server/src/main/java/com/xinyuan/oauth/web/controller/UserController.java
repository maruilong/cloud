package com.xinyuan.oauth.web.controller;

import com.xinyuan.oauth.entity.User;
import com.xinyuan.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author liang
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public Principal user(Principal principal) {

        User user = null;
        if (principal != null) {
            user = userService.findByUsername(principal.getName());
        }
        return principal;
    }
}
