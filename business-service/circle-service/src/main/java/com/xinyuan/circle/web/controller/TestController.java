package com.xinyuan.circle.web.controller;

import com.xinyuan.circle.config.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("port")
    public String showPort() {
        return testService.showPort();
    }

}
