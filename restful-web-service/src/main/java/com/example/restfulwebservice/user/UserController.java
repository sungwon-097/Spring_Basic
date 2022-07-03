package com.example.restfulwebservice.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; // class 명을 생략 가능
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

//    @GetMapping("/users/{id}")
//    public User retrieveUser(@PathVariable int id){ // string to int
//        User user = service.findOne(id);
//
//        if(user == null){ // user not found
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//        return user;
//    }

    // 아래는 hateos 사용
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){ // string to int
        User user = service.findOne(id);

        if(user == null){ // user not found
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        // 필요한 리소스를 그때그때 직접 작업하지 않더라도 hateos 사용으로 추가로 사용 할 수 있는 링크가 자동으로 설계됨
        EntityModel<User> model = EntityModel.of(user); // 생성자가 protected 되어있음
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers()); // static import
        model.add(linkTo.withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        //ServletUriComponentsBuilder : 사용자에게 요청값을 변환해줌
        //fromCurrentRequest : 현재 요청되어진 request 값을 사용
        //path : 반환값 지정
        //buildAndExpand : 가변인자에 값 지정
        //toUri : uri 형태로 변환

        return ResponseEntity.created(location).build();
        // 저장된 주소값을 빌드해 반환
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id); // id 값을 가진 유저를 삭제 후 user 반환

        if(user == null){ // user not found
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }
}