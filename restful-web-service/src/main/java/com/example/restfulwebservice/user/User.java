package com.example.restfulwebservice.user;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"}) // 원하는 값만 표시하지 않도록 설정
@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min=2, message = "Name : 2 글자 이상입니다")
    private String name;
    @Past
    private Date joinDate;

//    @JsonIgnore // json 타입의 값을 무시하여 표시하지 않음
    private String password;
//    @JsonIgnore
    private String ssn;
}