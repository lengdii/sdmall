package com.lengdi.eureka.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Date:2023/03/10/ 16:26
 * Author:leng
 * Description:
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //设置当前服务器的所有请求都要使⽤spring security的认证

        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
