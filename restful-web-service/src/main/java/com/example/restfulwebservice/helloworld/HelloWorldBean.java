package com.example.restfulwebservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // lombok
@AllArgsConstructor
public class HelloWorldBean {
    private String message;
//    public String getMessage(){           //--> lombok
//        return this.message;
//    }
//    public void setMessage(String msg){
//        this.message = msg;
//    }
//    public HelloWorldBean(String message) {
//        this.message = message;
//    }
}