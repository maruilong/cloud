package com.xinyuan.relation.client.hystric;

import com.xinyuan.relation.client.HelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloHystric implements HelloClient {
    @Override
    public ResponseEntity<String> add(String name) {
        log.error(name);
        return ResponseEntity.ok("失败");
    }
}
