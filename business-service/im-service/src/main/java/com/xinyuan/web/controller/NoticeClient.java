package com.xinyuan.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xinyuan.web.request.RequestMessage;
import com.xinyuan.web.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 执行通知操作的客户端
 *
 * @author liang
 */
@Slf4j
@Controller
public class NoticeClient {

    /**
     * @param requestMessage
     * @return
     * @MessageMapping 指定要接收消息的地址，类似@RequestMapping。除了注解到方法上，也可以注解到类上
     * @SendTo默认 消息将被发送到与传入消息相同的目的地
     */
    @MessageMapping("/notice")
    @SendTo("/topic/notice/getResponse")
    public ResponseMessage notice(RequestMessage requestMessage) {
        log.info("通知消息:" + JSONObject.toJSONString(requestMessage));
        ResponseMessage responseMessage = new ResponseMessage();
        //sender以后是从登录系统里面取出来
        responseMessage.setSender(requestMessage.getSender());
        responseMessage.setMessage(requestMessage.getContent());
        return responseMessage;
    }
}
