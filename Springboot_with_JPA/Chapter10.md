-   Chapter10

## 3. Spring Boot 동작 원리(3)

2. Servlet Container

---

### Servlet Container

-   URL은 자원 접근, URI는 식별자 접근
    -   Spring에서는 자원에 직접 접근을 제한함, 요청 시에 무조건 Java를 거쳐야 함(Tomcat으로)

```
www.domain/a.png        (X) => URL
www.domain/picture/a    (O) => URI
```

-   Java와 관련된 자원을 Request 하게 되면 Servlet Container(Tomcat)가 호출됨
    -   Servlet객체 생성
        1. init()
        2. Service() -> Post, Get, Put, Delete
        3. Request마다 Thread가 생성되어 DB 연결, 데이터 요청, html에 담아서 응답 등의 처리를 함
        -   Servlet객체가 하나여도 메소드는 각각 따로 사용해야함(독립된 Thread)
        -   20개의 Thread가 있다고 할 때 21번째 요청은 다른 Thread가 Response할 때 까지 대기함. Thread 1이 응답을 끝냈다고 할 때 대기하고 있는 Thread 21은 Thread 1을 재사용함 => Pooling 기법
        -   Servlet객체도 재사용이 가능하지만 Servlet객체는 1개여야함
