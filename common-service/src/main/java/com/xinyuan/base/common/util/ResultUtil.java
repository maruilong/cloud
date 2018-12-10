package com.xinyuan.base.common.util;


import com.xinyuan.base.common.web.Message;

/**
 * @Author: hwz
 * @Date: Created in 16:10 2018/4/23.
 */
public class ResultUtil {
    public static Message success(Object object) {
        Message message = new Message();
        message.setCode(200);
        message.setMessage("success");
        message.setData(object);
        return message;
    }


    public static Message success() {
        return success(null);
    }


    public static Message error(Integer code, String msg) {
        Message message = new Message();
        message.setCode(code);
        message.setMessage(msg);
        return message;
    }
}
