package com.example.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// http status code
// 200 -> OK
// 400 -> Client
// 500 -> Server
@ResponseStatus(HttpStatus.NOT_FOUND) // 404오류로 전달
public class UserNotFoundException extends RuntimeException { //실행 시 발생하는 오류로 처리
    public UserNotFoundException(String message) {
        super(message);
    }
}