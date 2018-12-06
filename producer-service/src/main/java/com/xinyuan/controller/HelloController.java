package com.xinyuan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liang
 */
@RestController
public class HelloController {
    /**
     * 注入配置文件中的服务显示名称
     */
    @Value("${server.port}")
    private String port;

    /**
     * 提供输出hello信息
     *
     * @param name 名字
     * @return "hello @name,this is producer service message!"
     */
    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + ", this is " + port + " service message!";
    }


}
