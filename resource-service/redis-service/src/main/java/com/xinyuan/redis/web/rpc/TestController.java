package com.xinyuan.redis.web.rpc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hwz
 * @Date: Created in 18:38 2018/12/18.
 */
@RestController
public class TestController {

    @Value("${info.profile}")
    private String str;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> add() {

        return ResponseEntity.ok(str);
    }
}
