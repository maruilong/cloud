package com.xinyuan.redis.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * @Author: hwz
 * @Date: Created in 17:22 2018/12/17.
 */
public interface RedisClient {

    @RequestMapping(value = "/api/redis/getAllKeys", method = RequestMethod.POST)
    ResponseEntity<Set<String>> getAllKeys();
}
