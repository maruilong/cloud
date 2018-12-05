package com.xinyuan.web.controller;

import com.xinyuan.web.request.ChatRoomRequest;
import com.xinyuan.web.response.ChatRoomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author liang
 */
@Controller
public class RabbitMQServer {

    @Autowired
    private SimpMessagingTemplate template;

    //群发
    @MessageMapping("/massRequest")
    //SendTo 发送至 Broker 下的指定订阅路径
    @SendTo("/mass/getResponse")
    public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest) {
        //方法用于群发测试
        ChatRoomResponse response = new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setContent(chatRoomRequest.getContent());
        response.setSender(chatRoomRequest.getSender());
        return response;
    }

    //通知
    @MessageMapping("/notice")
    //SendTo 发送至 Broker 下的指定订阅路径
    @SendTo("/notice/getResponse")
    public ChatRoomResponse notice(ChatRoomRequest chatRoomRequest) {
        //方法用于群发测试
        ChatRoomResponse response = new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setContent(chatRoomRequest.getContent());
        response.setSender(chatRoomRequest.getSender());
        return response;
    }


    @MessageMapping("/aloneRequest")
    public ChatRoomResponse alone(ChatRoomRequest chatRoomRequest) {
        //方法用于一对一测试
        ChatRoomResponse response = new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setContent(chatRoomRequest.getContent());
        response.setSender(chatRoomRequest.getSender());
        this.template.convertAndSendToUser(chatRoomRequest.getName(), "/alone/getResponse", response);
        this.template.convertAndSendToUser(chatRoomRequest.getSender(), "/alone/getResponse", response);
        return response;
    }

}
