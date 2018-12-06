package com.xinyuan.web.controller;

import com.xinyuan.web.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liang
 */
@RestController
public class HelloController {
    /**
     * 远程调用接口
     */
    private final HelloRemote helloRemote;

    @Autowired
    public HelloController(HelloRemote helloRemote) {
        this.helloRemote = helloRemote;
    }

    /**
     * 输出hello方法
     *
     * @param name 名称
     * @return 远程调用返回值
     */
    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return helloRemote.hello(name);
    }

}
