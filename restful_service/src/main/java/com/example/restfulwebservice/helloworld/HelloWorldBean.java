package com.example.restfulwebservice.helloworld;
// lombok

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // setter, getter, toString 사용 가능
@AllArgsConstructor
@NoArgsConstructor // default 생성자가 만들어짐
public class HelloWorldBean {
    private String message;
//    public String getMessage(){
//        return this.message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }// 기본적인 bean클래스를 만드는 방법. lombok을 추가하였기 때문에 생략 가능하다
}
