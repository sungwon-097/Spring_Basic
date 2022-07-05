package com.example.restfulwebservice.user;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // database 와 관련된 bean
public interface UserRepository extends JpaRepository<User, Integer> {
    // JpaRepository 를 상속한 인터페이스 선언만으로 사용 가능
}
