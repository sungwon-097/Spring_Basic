-   Chapter13

## 3. Spring Boot 동작 원리(6)

7. 스프링 컨테이너

---

### Spring Container

-   request
-   web.xml
-   ContextLoaderListener
    -   root-context.xml
    -   모든 Thread들이 공유해서 사용하여야 하는 것들을 먼저 띄움
-   DispatchServlet(Component scan)
    -   Spring에선 src 하위의 모든 파일을 스캔해 필요한 파일을 올림
    -   annotation을 통해 올림
    -   스캔 후 주소를 분배한다

```java
// Annotation example
@Controller
@RestController
@Configration
@Repository
@Service
@Component
```

1. Application Context
    - IoC를 통해 수많은 객체들이 등록됨
    - DI하여 사용
    - Servlet-applicationContext  
      : 웹과 관련된 annotation(Controller, ViewResolver, HandlerMapping)
    - Root-applicationContext  
      : DB와 관련된 annotation(Services, Repository)
2. Bean Factory
    - 메모리에 초기에 로드되지 않고 필요할 때 getBean() 메소드를 호출하여 로드 할 수 있다
    - 필요할 때 DI하여 사용 할 수 있다(IoC)
    - Application Context와의 차이점
        - 미리 로드되지 않고 필요할 때 호출함
        - lazy-loading
