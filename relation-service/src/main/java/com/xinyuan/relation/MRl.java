package com.xinyuan.relation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MRl {

    @Value("${mrl}")
    private String mrl;

    @Bean
    public A aaa() {
        System.out.println(mrl);
        return new A();
    }


}

class A {

}