package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // spring bean의 타입
public interface UserRepository extends JpaRepository<User, Integer> {
}
// 인터페이스 생성만으로 CRUD 에 관련된 메소드 사용 가능