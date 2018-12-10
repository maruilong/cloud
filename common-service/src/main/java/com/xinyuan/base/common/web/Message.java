package com.xinyuan.base.common.web;

import lombok.Data;

/**
 * @author hzx
 * @Description:
 * @date 2018/4/918:27
 */
@Data
public class Message<T> {

    private String message;

    private int code;

    private T data;

    private String name;
}
