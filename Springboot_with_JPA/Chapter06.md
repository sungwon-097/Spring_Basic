-   Chapter06

## 2. JPA란?(3)

4. JPA는 영속성 컨텍스트를 가지고 있다
5. JPA는 DB와 OOP의 불일치성을 해결하기 위한 방법론을 제공한다(DB는 객체 저장 불가능)

---

### 영속성

-   데이터를 영구적으로 저장

### Context

-   Context를 가지고 있다 == 모든 정보를 다 알고 있다
-   대상이 되는 모든 정보
-   Java program에서 DB에 정보를 저장하고 싶으면 Persistence Context를 거쳐서 DB에 보냄
-   Java program, Persistence Context, Database는 동기화되어 있다. Database의 정보와 다르다면 update문을 자동으로 호출

### + ORM

-   Table

| Team table |      |      | Player table |      |        |
| ---------- | ---- | ---- | ------------ | ---- | ------ |
| ID         | Name | Year | ID           | Name | TeamID |

-   Object

```java
class Team{
    int id;
    String name;
    String year;
}
...
class Player{
    int id;
    String name;
    Team TeamID; // java에서는 기본 자료형이 아닌 Object를 저장 가능(*)
}
```

-   ORM사용하게 되면 자바가 주도권을 쥐고 있는 모델을 만들 수 있다
-   (\*)과 같은 상황에서 insert, select시 JPA가 자동으로 Mapping해줌
-   ORM을 통해 불일치성을 해결 가능함
