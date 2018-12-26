package com.xinyuan.circle.config.service.hystric;

import com.xinyuan.circle.config.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 断路器 当原来任务失败的时候执行
 *
 * @author liang
 */
@Slf4j
@Component
public class RedisHystric implements RedisService {

    @Override
    public ResponseEntity<Set<String>> getAllKeys() {
        log.error("----------------出错 " );
        return null;
    }
}
