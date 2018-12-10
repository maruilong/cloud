package com.xinyuan.circle.common.service;

/**
 * 参数条件
 *
 * @author
 * @since 2018-03-13
 */
public enum ParamCondition {

    /**
     * 等于
     * */
    EQUAL,
    /**
     * 大于
     * */
    GREATERTHAN,
    /**
     * 小于
     * */
    LESSTHAN,
    /**
     * 模糊查询
     * */
    LIKE,
    /**
     * 大于等于
     * */
    GREATERTHANEQUAL,
    /**
     * 小于等于
     * */
    LESSTHANEQUAL,
    /**
     * in
     */
    IN,
    /**
     * 不等于
     */
    NOT_EQUAL
}
