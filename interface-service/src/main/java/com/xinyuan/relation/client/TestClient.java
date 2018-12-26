package com.xinyuan.relation.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TestClient {

    @RequestMapping(value = "/relation/port", method = RequestMethod.GET)
    String showPort();
}
