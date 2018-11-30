package com.xinyuan.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xinyuan.web.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liang
 */
@RestController
public class OrderController {

    @Autowired
    private OrderClient orderClient;

    @RequestMapping(value = "/queryOrder", method = RequestMethod.GET)
    public String queryOrder(@RequestParam String name) {
        return orderClient.queryOrder(name);
    }


}
