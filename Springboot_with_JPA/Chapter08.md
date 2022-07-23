-   Chapter08

## 3. Spring Boot 동작 원리(1)

0. HTTP란?

---

### Socket

-   운영체제가 가지고 있음
-   Stateful방식
-   스레드를 사용해 시분할 방식으로 동시 운용
-   Socket통신은 사용자가 많아질수록 부하가 많아짐

### HTTP

-   문서를 전달하는 통신
-   Stateless방식, 문서(html) 전달 후 접속을 끊음
-   server의 입장에서는 client를 구분하지 못함
    -   Web Server에서 단점을 보완
