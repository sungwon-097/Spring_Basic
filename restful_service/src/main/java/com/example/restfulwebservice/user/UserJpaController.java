package com.example.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired // 의존성 주입
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    // http://localhost:8088/jpa/users or http://localhost:8088/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id); // 검색어가 존재하지 않을 수도 있기 때문에 Optional 선언

        if (!user.isPresent()) { // user 데이터가 존재하지 않는 경우 예외처리
            throw new UserNotFoundException(String.format("ID[%s} not found", id));
        }

        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers()); // 전체목록보기 링크데이터 생성
        resource.add(linkTo.withRel("all-users")); // resource 에 링크 추가

        return resource;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) { // 존재하지 않는다면 notfound exception 을 반환
            throw new UserNotFoundException(String.format("ID[%s} not found", id));
        }

        User storedUser = optionalUser.get();
        storedUser.setName(user.getName());
        storedUser.setPassword(user.getPassword());

        User updatedUser = userRepository.save(storedUser);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // /jpa/users/90001/posts
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int id) { // 개별 사용자가 가진 post 정보를 가져옴
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s} not found", id));
        }

        return user.get().getPosts();
    } // user 데이터가 존재 할 때 post 데이터를 가져옴

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s} not found", id));
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}/posts/{post_id}")
    public void deletePost(@PathVariable int id, @PathVariable int post_id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s} not found", id));
        } else {
            postRepository.deleteById(post_id);
        }
    }
}