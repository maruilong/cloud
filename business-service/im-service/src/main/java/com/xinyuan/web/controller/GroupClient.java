package com.xinyuan.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xinyuan.web.request.RequestMessage;
import com.xinyuan.web.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GroupClient {


    /**
     * @param requestMessage
     * @return
     * @MessageMapping 指定要接收消息的地址，类似@RequestMapping。除了注解到方法上，也可以注解到类上
     * @SendTo默认 消息将被发送到与传入消息相同的目的地
     */
    @MessageMapping("/group")
    @SendTo("/topic/getGroupResponse")
    public ResponseMessage notice(RequestMessage requestMessage) {
        log.info("群发消息:" + JSONObject.toJSONString(requestMessage));
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setSender(requestMessage.getSender());
        responseMessage.setContent(requestMessage.getContent());
        return responseMessage;
    }

}
