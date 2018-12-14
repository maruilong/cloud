package com.xinyuan.relation.web.rpc;

import com.xinyuan.relation.client.HelloClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi implements HelloClient {
    @Override
    public ResponseEntity<String> add(String name) {
        return ResponseEntity.ok("添加成功");
    }
}
