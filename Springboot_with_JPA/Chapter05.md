-   Chapter05

## 2. JPA란?(2)

2. JPA는 ORM 기술이다
3. JPA는 반복적인 CRUD 작업을 생략하게 해준다

---

### ORM

-   Object Relational Mapping
-   DB

| key  | val     |
| ---- | ------- |
| id   | int     |
| name | varchar |
| year | varchar |

-   Object

```java
Class Team{
    int id;
    String name;
    String year;
}
```

-   ORM : Jpa가 가지고 있는 인터페이스의 규칙을 지키고 클래스를 만들어서 실행 하면 DB의 테이블을 자동으로 생성되게 하는 기법

### CRUD

-   Create
    -   insert
-   Read
    -   select(단건)
    -   select all(전체)
-   Update
-   Delete

1. Java program에서 DB로 Connection을 요청함
2. DB 에서 신분을 확인하고 session을 열어줌
3. DB 에선 세션을 오픈하고 Java program에선 Connection을 가진다
4. 두번째 요청 부터는 DB로 Query를 전송 할 수 있음
5. DB는 Query를 통해 Table을 만들어내고 Java에 응답함
6. Java는 응답받은 데이터를 Object로 변경함

-   JPA를 사용하면 위의 일련의 작업들을 함수화해서 간단히 제공함
