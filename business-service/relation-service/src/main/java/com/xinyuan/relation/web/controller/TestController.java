package com.xinyuan.relation.web.controller;

import com.xinyuan.relation.client.TestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RefreshScope
public class TestController implements TestClient {

    @Value("${person}")
    private String person;


    @RequestMapping("person")
    public String showPerson() {
        log.info(person);
        return person;
    }

    @Value("${server.port}")
    private String port;

    public String showPort() {
        log.info("我的端口是:" + port);
        return "我的端口是:" + port;
    }

    @RequestMapping("user")
    public Principal user(Principal principal) {
        return principal;
    }

}
