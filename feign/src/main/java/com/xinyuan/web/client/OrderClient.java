package com.xinyuan.web.client;

import com.xinyuan.web.hystric.OrderHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liang
 */
@FeignClient(value = "order-service", fallback = OrderHystric.class)
public interface OrderClient {

    /**
     * 查询
     * @param name
     * @return
     */
    @RequestMapping(value = "/order/queryOrder", method = RequestMethod.GET)
    String queryOrder(@RequestParam(value = "name") String name);

}
