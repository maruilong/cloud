//package com.xinyuan.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
///**
// * 资源服务器
// *
// * @author liang
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().formLogin();
////                .authorizeRequests().anyRequest().authenticated().and()
////                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//
//
//    }
//}