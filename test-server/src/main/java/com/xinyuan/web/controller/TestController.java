package com.xinyuan.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author liang
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
