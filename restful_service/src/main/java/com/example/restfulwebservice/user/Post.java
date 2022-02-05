package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // jpa
@Data //lombok 플러그인
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // User : Post -> 1 : (0~N), Main : Sub -> Parent : Child
    @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne : 여러개의 post 값이 하나로 매칭 될 수 있음
    // LAZY 지연로딩방식. post data 가 로딩되는 시점에 필요한 데이터를 가져옴
    @JsonIgnore
    private User user;
}
