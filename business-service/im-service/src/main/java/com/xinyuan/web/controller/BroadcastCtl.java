package com.xinyuan.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xinyuan.web.request.RequestMessage;
import com.xinyuan.web.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用于对前台webSocket的接受
 *
 * @author liang
 */
@Slf4j
@Controller
public class BroadcastCtl {

    /**
     * 收到消息记数
     */
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * @param requestMessage
     * @return
     * @MessageMapping 指定要接收消息的地址，类似@RequestMapping。除了注解到方法上，也可以注解到类上
     * @SendTo默认 消息将被发送到与传入消息相同的目的地
     * 消息的返回值是通过{@link org.springframework.messaging.converter.MessageConverter}进行转换
     */
    @MessageMapping("/receive")
    @SendTo("/exchange/rabbitmq/get-response")
    public ResponseMessage toGroup(RequestMessage requestMessage) {
        log.info("receive content = {}", JSONObject.toJSONString(requestMessage));
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("BroadcastCtl receive [" + count.incrementAndGet() + "] records");
        return responseMessage;
    }

    // @MessageMapping 指定要接收消息的地址，类似@RequestMapping。除了注解到方法上，也可以注解到类上
    @MessageMapping("/receive-single")
    /**
     * 也可以使用SendToUser，可以将将消息定向到特定用户
     * 这里使用 @SendToUser，而不是使用 @SendTo
     */
    @SendToUser("/topic/getResponse")
    public ResponseMessage toUser(RequestMessage requestMessage) {
        ResponseMessage responseMessage = new ResponseMessage();
        return responseMessage;
    }

}
