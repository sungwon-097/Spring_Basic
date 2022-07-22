-   Chapter02

## 1. 스프링이란?(2)

5. 스프링은 엄청나게 많은 필터를 가지고 있다
6. 스프링은 엄청나게 많은 어노테이션을 가지고 있다(리플렉션, 컴파일체킹)

---

### 필터

-   필터는 쉽게 말해 문지기라고 생각하면 됨.
    1.  스프링 자체에서 기본적으로 가진 필터 기능
    2.  사용되지 않고 있는 필터를 사용하겠다고 설정
    3.  사용자지정 필터를 생성해 사용
-   Tomcat이 들고 있는 filter -> web.xml
-   Spring Container가 들고 있는 filter(intercepter)
-   권한을 체크해 접근할 수 있도록 함

### 어노테이션

-   어노테이션은 컴파일러가 무언가를 체크할 수 있도록 힌트를 주는 주석의 개념(컴파일 시 체크)

```java
@Override // redefine method
@Component // load on memory(use IoC)
@Autowired // Put the loaded object into that variable(Dependency Injection)
```

-   리플렉션 : 어떤 해당 클래스가 어떤 필드, 메소드, 어노테이션등을 가지고 있는지 분석하는 기법, 런타임에 일어남
