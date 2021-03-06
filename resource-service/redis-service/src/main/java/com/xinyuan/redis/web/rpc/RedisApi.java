package com.xinyuan.redis.web.rpc;

import com.xinyuan.redis.client.RedisClient;
import com.xinyuan.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Author: hwz
 * @Date: Created in 17:27 2018/12/17.
 */
@RefreshScope
@RestController
public class RedisApi implements RedisClient {

    @Autowired
    private RedisService redisService;

    @Override
    public ResponseEntity<Set<String>> getAllKeys() {
        Set<String> allKeys = redisService.getAllKeys();

        return ResponseEntity.ok(allKeys);
    }

}
