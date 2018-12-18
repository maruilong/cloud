package com.xinyuan.circle.service;

import com.xinyuan.circle.service.hystric.RedisHystric;
import com.xinyuan.redis.client.RedisClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shinian
 */
@FeignClient(value = "redis-service", fallback = RedisHystric.class)
public interface RedisService extends RedisClient {
}
