package com.xinyuan.base.common.web;

import lombok.Data;

/**
 * @author hzx
 * @Description:
 * @date 2018/4/918:27
 */
@Data
public class Conditions {

    private String key;

    private Object value;

    private String condition;

    public Conditions() {
    }

    public Conditions(String key, Object value, String condition) {
        this.key = key;
        this.value = value;
        this.condition = condition;
    }
}
