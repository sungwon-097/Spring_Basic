-   Chapter07

## 2. JPA란?(4)

6. JPA는 OOP의 관점에서 모델링은 할 수 있게 해준다(상속, 콤포지션, 연관관계)
7. 방언처리가 용이하여 Migration 하기 좋고, 유지보수에도 좋다
8. JPA는 쉽지만 어렵다

---

### Composition

```java
class Engine{
    int id;
    int power;
}
...
class Car{ // Engine class 상속은 안됨.
    String name;
    String color;
    Engine engine;
}
```

| Car Table |      |       |          | Engine Table |       |
| --------- | ---- | ----- | -------- | ------------ | ----- |
| id        | name | color | engineID | id           | power |
| 1         | BMW  | white | [2]      | [1]          | 200   |
|           |      |       |          | [2]          | 250   |

### Inheritance

```java
class Engine extends EntityDate{
    int id;
    int power;
    // Timestamp createDate;
    // Timestamp updateDate;
}
...
class Car extends EntityDate{
    String name;
    String color;
    Engine engine;
    // Timestamp createDate;
    // Timestamp updateDate;
}
...
class EntityDate{
    Timestamp createDate;
    Timestamp updateDate;
}
```

| Car Table |      |       |          |            |            |
| --------- | ---- | ----- | -------- | ---------- | ---------- |
| id        | name | color | engineID | createDate | updateDate |

### Migration

-   추상화 객체를 바라보는 JPA를 사용하기 때문에 migration에 용이함
