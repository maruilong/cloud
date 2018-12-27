package com.xinyuan.web.controller;


import com.alibaba.fastjson.JSON;
import com.xinyuan.web.request.RequestMessage;
import com.xinyuan.web.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "sendToUser")
    public void sendToUser(RequestMessage requestMessage) {

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setSender(requestMessage.getSender());
        responseMessage.setMessage(requestMessage.getMessage());
        responseMessage.setName(requestMessage.getName());

        template.convertAndSendToUser(requestMessage.getName(), "/topic/private", JSON.toJSONString(responseMessage));
    }
}
