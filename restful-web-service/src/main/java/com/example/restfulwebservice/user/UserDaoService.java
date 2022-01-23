package com.example.restfulwebservice.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//@Component도 가능하지만 명확히 service용도인 것을 알 수 있음
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;
    static{
        users.add(new User(1, "Choi", new Date(), "pass1", "701010-1111111"));
        users.add(new User(2, "Sung", new Date(), "pass2", "701010-1111112"));
        users.add(new User(3, "Won", new Date(), "pass3", "701010-1111113"));
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
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
