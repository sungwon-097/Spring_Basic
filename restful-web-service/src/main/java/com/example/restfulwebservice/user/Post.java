package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // jpa 사용
@Data // setter, getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    // User : Post -> parent : child
    @ManyToOne(fetch = FetchType.LAZY) // post 값이 여러 개가 올 수 있고 하나의 값과 매칭됨(게시물의 게시자는 하나, 지연로딩 lazy하게 불러옴)
    // post 데이터가 로딩되는 시점에 필요한 사용자 데이터를 가져(post entity 에서 바로 가져오지 않음)
    @JsonIgnore // 외부에 json 데이터가 공개되지 않음
    private User user;
}
