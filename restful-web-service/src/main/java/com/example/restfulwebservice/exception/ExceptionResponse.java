package com.example.restfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor // lombok의 기능으로 getter, setter 지동 생성
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}