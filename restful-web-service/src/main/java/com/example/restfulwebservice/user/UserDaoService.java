package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
// or @Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static{
        users.add(new User(1, "Kennith", new Date(), "pass1", "701010-1111111"));
        users.add(new User(2, "Alice", new Date(),"pass2", "801010-1111111"));
        users.add(new User(3, "Elena", new Date(),"pass3", "901010-1111111"));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    public User findOne(int id){
        for(User user: users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator(); // 현재 class 의 users 를 가리키는 iterator

        while(iterator.hasNext()){
            User user = iterator.next(); // users info 를 순차적으로 저장함

            if(user.getId() == id){ // parameter 와 일치하면 삭제 후 현재 user 목록 반환
                iterator.remove();
                return user;
            }
        }
        return null; // default return
    }
}
