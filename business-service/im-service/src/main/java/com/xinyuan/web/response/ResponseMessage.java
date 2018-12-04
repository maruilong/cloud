package com.xinyuan.web.response;

import lombok.Data;

import java.util.Map;

/**
 * @author liang
 */
@Data
public class ResponseMessage {

    private String sender;

    private Map<String, Object> content;

    private String name;
}
