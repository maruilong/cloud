package com.xinyuan.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liang
 */
@Slf4j
@RestController
public class OrderController {

    @GetMapping("/queryOrder")
    public String queryOrder(@RequestParam String name) {
        log.info(this.getClass().getSimpleName());
        return name + "订单系统";
    }

}
