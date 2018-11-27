package com.xinyuan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserService userService;

    public List<String> findRoles(Long id) {
        return new ArrayList<>();
    }
}
