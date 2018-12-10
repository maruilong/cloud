package com.xinyuan.common.service;

import com.xinyuan.c.common.service.ParamCondition;
import com.xinyuan.common.service.ParamCondition;
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
