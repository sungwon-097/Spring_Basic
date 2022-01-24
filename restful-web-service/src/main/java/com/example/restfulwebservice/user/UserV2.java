package com.example.restfulwebservice.user;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"}) // 원하는 값만 표시하지 않도록 설정
@JsonFilter("UserInfoV2")
public class UserV2 extends User {
    private String grade;
}