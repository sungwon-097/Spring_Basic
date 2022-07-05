package com.example.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent()){
             throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        EntityModel<User> model = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers()); // retrieveAllUsers 와 연동시킴
        model.add(linkTo.withRel("all-users"));

        return model;
    }

    @DeleteMapping("/user/{id}")
    public void deleteuser(@PathVariable int id){
        repository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){  // 유효성 검사와 json 형태로 데이터를 받기 위한 annotation
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")// 현재 생성 되어있는 id
                .buildAndExpand(savedUser.getId())// 저장되어진 객체의 id 값
                .toUri(); // uri 에 매핑

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int id){
        Optional<User> user = repository.findById(id); // retrieveUser 메소드의 로직을 그대로 가져옴

        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        List<Post> post = user.get().getPosts();

        if(post.isEmpty()){
             System.out.println("Post not found");
        }
        return post;
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")// 현재 생성 되어있는 id
                .buildAndExpand(savedPost.getId())// 저장되어진 객체의 id 값
                .toUri(); // uri 에 매핑

        return ResponseEntity.created(location).build();
    }
}