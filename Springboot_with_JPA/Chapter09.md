-   Chapter09

## 3. Spring Boot 동작 원리(2)

1. 내장 톰켓을 가지기 때문에 따로 톰캣을 설치할 필요가 없음
2.

---

### Socket

-   운영체제가 가지고 있음
-   Stateful방식
-   스레드를 사용해 시분할 방식으로 동시 운용
-   Socket통신은 사용자가 많아질수록 부하가 많아짐

### HTTP

-   문서를 전달하는 통신
-   Stateless방식
-   server의 입장에서는 client를 구분하지 못함
    -   Web Server에서 단점을 보완
