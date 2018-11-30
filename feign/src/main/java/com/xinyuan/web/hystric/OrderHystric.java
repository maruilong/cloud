package com.xinyuan.web.hystric;

import com.xinyuan.web.client.OrderClient;
import org.springframework.stereotype.Component;

/**
 * 断路器 当原来任务失败的时候执行
 *
 * @author liang
 */
@Component
public class OrderHystric implements OrderClient {
    @Override
    public String queryOrder(String name) {
        return name + "调用错误!!";
    }
}
