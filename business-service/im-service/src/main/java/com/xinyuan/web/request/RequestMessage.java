package com.xinyuan.web.request;

import lombok.Data;

import java.util.Map;

/**
 * 浏览器向服务端请求的消息
 *
 * @author liang
 */
@Data
public class RequestMessage {

    private String sender;

    private Map<String, Object> content;

    private String name;

}
