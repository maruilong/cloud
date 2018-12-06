package com.xinyuan.web.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign远程调用接口
 * FeignClient注解的name属性值要写服务提供者在注册中心注册的服务名称
 *
 * @author liang
 */
@FeignClient(name = "producer-service")
public interface HelloRemote {
    /**
     * 远程调用方法
     *
     * @param name 名称
     * @return 远程调用结果
     */
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

}
