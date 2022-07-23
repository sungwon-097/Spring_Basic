-   Chapter09

## 3. Spring Boot 동작 원리(2)

1. 내장 톰켓을 가지기 때문에 따로 톰캣을 설치할 필요가 없음

---

### Tomcat

-   Web Server
    -   URL 주소로 자원을 요청함
    -   http: \*/a.html
    -   static한 자원을 요청
    -   Apache
        -   자원을 request받으면 response로 응답함
        -   JSP(Java Server Pages) 받으면 응답할 수가 없음 -> Tomcat으로 보냄
        -   Tomcat에서 모든 자바 코드를 컴파일하고 html문서로 만들어줌
