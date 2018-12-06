package com.xinyuan.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author liang
 */
@Slf4j
@RestController
public class OrderController {

    @GetMapping("/queryOrder")
    public String queryOrder(@RequestParam String name, Principal principal) {
        log.info(principal.toString());
        log.info(this.getClass().getSimpleName());
        return name + "订单系统";
    }

}
