-   Chapter12

## 3. Spring Boot 동작 원리(5)

4. Front Controller 패턴
5. RequestDispatcher
6. DispatchServlet

---

### Front Controller 패턴

-   request 요청을 먼저 받아서 필요한 class에 넘겨줌  
    : web.xml에 모두 정의하기가 힘들기 때문
-   request와 response가 새로 new 될 수 있기 떄문에 RequestDispatcher가 필요

### RequestDispatcher

-   기존에 존재하던 request와 response를 그대로 유지시켜준다(페이지간 데이터의 이동이 가능하게 하기 위함)

### DispatchServlet

-   FrontController 패턴 + RequestDispatcher
-   스프링에는 DispatchServlet가 존재
