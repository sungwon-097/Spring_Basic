package com.example.restfulwebservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import java.net.Authenticator;

@Configuration
public class SecurityConfig extends WebSecurityConfiguration {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws  Exception{
        auth.inMemoryAuthentication()
                .withUser("kennith")
                .password("{noop}test1234")
                .roles("USER");
    }
}