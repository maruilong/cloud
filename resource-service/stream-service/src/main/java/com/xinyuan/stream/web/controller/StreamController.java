package com.xinyuan.stream.web.controller;

import com.xinyuan.stream.client.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hwz
 * @Date: Created in 11:47 2018/12/18.
 */
@Slf4j
@RestController
public class StreamController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("send")
    public void send() {
        streamClient.output().send(MessageBuilder.withPayload("Hello World...").build());
    }

    @GetMapping("receiver")
    @StreamListener(StreamClient.INPUT)
    public void receive(String message) {
        log.info("StreamReceiver: {}", message);

    }

}
