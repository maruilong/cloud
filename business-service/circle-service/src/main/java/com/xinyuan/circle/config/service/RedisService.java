package com.xinyuan.circle.config.service;

import com.xinyuan.circle.config.service.hystric.RedisHystric;
import com.xinyuan.redis.client.RedisClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shinian
 */
@FeignClient(value = "redis-service", fallback = RedisHystric.class)
public interface RedisService extends RedisClient {
}
