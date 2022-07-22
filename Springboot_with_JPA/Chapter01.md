-   Chapter01

## 1. 스프링이란?(1)

1.  스프링은 프레임워크이다 : 틀에 맞춰서 개발을 하도록 유도
2.  스프링부트는 오픈소스이다 : 소스코드가 공개되어있어 내부를 뜯어고칠 수 있음
3.  스프링은 IoC 컨테이너를 가진다 : Inversior of Controll
4.  스프링은 DI 를 지원한다 : Dependency Injection

---

```java
// class : 설계도
// object : 실체화가 가능 한 것
// instance : 실체화 된 것

package spring.user

public class User{
    public User createUser(@PathVariable int id){
        User user = new User();
        ...
    }
}
// -> object를 실체화된 instance로 생성(heap공간에 new로)

package spring.login

@Service
public class Login{
    @Autowired
    private User user;
}
// 다른 메소드에서 new로 생성하면 위와는 다른 메모리 공간을 나타내게 됨
// -> 스프링이 스캔하여 객체를 직접 메모리에 띄움(IoC, 제어권 역전)
// -> 객체간의 의존성을 자신이 아닌 외부에서 주입(DI)
```
