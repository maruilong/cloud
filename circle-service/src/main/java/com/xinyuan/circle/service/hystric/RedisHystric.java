package com.xinyuan.circle.service.hystric;

import com.xinyuan.circle.service.RedisService;
import com.xinyuan.circle.service.RelationService;
import com.xinyuan.relation.model.dto.RelationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
