package com.xinyuan.circle.web.controller;

import com.xinyuan.circle.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RefreshScope
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("port")
    public ResponseEntity<String> showPort() {
        return ResponseEntity.ok(testService.showPort());
    }


    @RequestMapping("user")
    public Principal user(Principal principal) {
        return principal;
    }
}
