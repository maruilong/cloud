package com.xinyuan.stream.receiver;

import com.xinyuan.stream.client.StreamClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

/**
 * @Author: hwz
 * @Date: Created in 11:44 2018/12/18.
 */
@Component
@EnableBinding(value = {StreamClient.class})
public class StreamReceiver {
    private Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

//    @StreamListener(StreamClient.INPUT)
//    public void receive(String content) {
//        logger.info("StreamReceiver: {}", content);
//
//    }

}
