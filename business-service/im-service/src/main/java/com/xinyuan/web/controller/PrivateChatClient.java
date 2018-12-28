package com.xinyuan.web.controller;


import com.alibaba.fastjson.JSON;
import com.xinyuan.web.request.RequestMessage;
import com.xinyuan.web.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * 执行单对单操作的客户端
 * 没有登录的版本
 *
 * @author liang
 */
@Slf4j
@Controller
public class PrivateChatClient {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping(value = "sendToUser")
    public void sendToUser(RequestMessage requestMessage) {

        log.info("单聊:" + requestMessage);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setSender(requestMessage.getSender());
        responseMessage.setContent(requestMessage.getContent());
        responseMessage.setName(requestMessage.getName());
        template.convertAndSendToUser(requestMessage.getSender(), "/queue/private", JSON.toJSONString(responseMessage));
        template.convertAndSendToUser(requestMessage.getName(), "/queue/private", JSON.toJSONString(responseMessage));
    }
}
