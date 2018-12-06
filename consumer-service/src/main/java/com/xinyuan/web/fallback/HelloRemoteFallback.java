package com.xinyuan.web.fallback;

import com.xinyuan.web.remote.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * 熔断回调类
 * 继承feign远程调用接口，并在实现方法中输出回调的信息
 *
 * @author liang
 */
@Component
public class HelloRemoteFallback implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello " + name + ", this message is failed";
    }
}
