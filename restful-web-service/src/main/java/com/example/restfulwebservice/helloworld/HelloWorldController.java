package com.example.restfulwebservice.helloworld;

import com.example.restfulwebservice.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired // annotation 을 통한 의존성 주입. 현재 spring framework 에 등록된 bean 중 같은 Type 을 가지고 있는 Bean 을 주입해줌
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable(value = "name") String name){ // value 생략 가능
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language", required = false) Locale locale){ // required : default 값이 필요한지
        return messageSource.getMessage("greeting.message", null, locale);
    }
}