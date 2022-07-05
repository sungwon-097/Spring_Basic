package com.example.restfulwebservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // spring boot 가 기동하면서 메모리에 설정 정보를 함께 로딩함
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception { // command + n => override method
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll(); // h2 권한 인증처리
        http.csrf().disable(); // CSRF(Cross-Site Request Forgery) 보안 비활성화
        http.headers().frameOptions().disable(); // header 에 frame 과 관련된 속성값 사용 안함
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication() // 메모리 방식의 auth
                .withUser("kennith")
                .password("{noop}test1234") // no operation : 인코딩 없이 바로 사용 할 값
                .roles("User");
    }
}