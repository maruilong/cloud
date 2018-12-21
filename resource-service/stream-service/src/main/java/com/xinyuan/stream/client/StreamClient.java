package com.xinyuan.stream.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: hwz
 * @Date: Created in 11:43 2018/12/18.
 */
public interface StreamClient {
    String INPUT = "myInput";
    String OUTPUT = "myOutput";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}
