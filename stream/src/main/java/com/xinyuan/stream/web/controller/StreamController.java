package com.xinyuan.stream.web.controller;

import com.xinyuan.stream.client.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hwz
 * @Date: Created in 11:47 2018/12/18.
 */
@RestController
public class StreamController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("send")
    public void send() {
        streamClient.output().send(MessageBuilder.withPayload("Hello World...").build());
    }

}
