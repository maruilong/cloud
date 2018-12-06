package com.xinyuan.common.service;


/**
 * @Author: hwz
 * @Date: Created in 10:43 2018/4/24.
 */
public class Order {
    public String direction;

    public String properties;

    public Order(String direction, String properties) {
        super();
        this.direction = direction;
        this.properties = properties;
    }

    public Order() {
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
