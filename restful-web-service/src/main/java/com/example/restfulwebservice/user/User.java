package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past; // Add dependency : hibernate-validator
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor // default constructor 가 존재하지 않아 상속 불가하기 때문에 선언해줌
//@JsonIgnoreProperties(value={"password", "ssn"}) // class block 으로 한 번에 ignore
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.") // method 에 @Valid 선언, valid 조건과 error message 선언
    @ApiModelProperty(notes = "사용자 이름을 입력 해 주세요")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용의 등록을 입력 해 주세요")
    private Date joinDate;

//    @JsonIgnore // 각각의 json 전달값을 무시(보안측면)
    @ApiModelProperty(notes = "사용자 패스워드를 입력 해 주세요")
    private String password;

//    @JsonIgnore
    @ApiModelProperty(notes = "사용자 주민번호를 입력 해 주세요")
    private String ssn;
}