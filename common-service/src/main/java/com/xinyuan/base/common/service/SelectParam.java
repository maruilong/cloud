package com.xinyuan.base.common.service;

import lombok.Data;

/**
 * @author liang
 */
@Data
public class SelectParam {
    /**
     * 参数键
     */
    private String paramKey;
    /**
     * 参数值
     */
    private Object paramValue;

    /**
     * 参数类型
     */
    private ParamCondition condition;

    public SelectParam() {
    }

    public SelectParam(String paramKey, Object paramValue, ParamCondition condition) {
        this.paramKey = paramKey;
        this.paramValue = paramValue;
        this.condition = condition;
    }
}
