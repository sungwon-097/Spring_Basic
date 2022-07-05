package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // database 와 관련된 bean
public interface PostRepository extends JpaRepository<Post, Integer> {
    // 상속된 인터페이스 선언으로 사용
}
