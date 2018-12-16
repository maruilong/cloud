package com.xinyuan.relation.client;

import com.xinyuan.relation.client.hystric.HelloHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "relation-service", fallback = HelloHystric.class)
public interface HelloClient {

    @RequestMapping(value = "/api/hello", method = RequestMethod.POST)
    ResponseEntity<String> add(String name);
}
