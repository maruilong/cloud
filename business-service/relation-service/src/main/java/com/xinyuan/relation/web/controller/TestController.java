package com.xinyuan.relation.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Value("${person}")
    private String person;


    @RequestMapping("person")
    public String showPerson() {
        log.info(person);
        return person;
    }

}
