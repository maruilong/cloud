package com.xinyuan.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring Security配置
 * Created on 2017/12/26.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .defaultSuccessUrl("/index")
                .and().authorizeRequests()
                .antMatchers("/authentication/require",
                        "/authentication/form",
                        "/user",
                        "/index",
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.jpg",
                        "/**/*.png",
//                        "/**/*.html",
                        "/**/*.woff2"
                )
                .permitAll()
                .and()
                .csrf().disable();
    }
}
