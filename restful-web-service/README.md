- Restful Web Service

### 1. RestApi?

- REST API 에서 REST는 Representational State Transfer 의 약자로 소프트웨어 프로그램 아키텍처의 한 형식
- HTTP URI를 통해 자원을 명시하고, HTTP Method (POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD OPERATION을 적용하는 것을 의미
- 웹의 모든 자원에 고유한 ID인 HTTP URI 를 부여

### 2. Spring Boot 의 동작 원리

- 스프링에는 Sublet Container 인 Tomcat 이 내장되어있음(서블릿 컨테이너는 HTTP 요청을 받아 웹페이지를 동적으로 생성하는 역할)
  - 스프링에서 URL 요청을 막고 있기 때문에 URi 요청방식을 사용
    - URL : http://naver.com/a.png
    - URI : http://naver.com/picture/a
    - URI 는 식별하고, URL 은 위치를 가리킨다.
    
- web.xml
  - ServletContext 의 초기 파라미터 설정(권한과 인증 체크/필터링)
  - Session 의 유효시간 설정
  - Servlet/JSP 에 대한 정의 및 매핑
  - Mime Type 매핑
  - Welcome File list(공통된 영역을 보내주기 위한 파일)
  - Error Pages 처리
  - Listener / Filter 설정
  - Security

- DispatcherServlet
  - FrontController 패턴과 RequestDispatcher 기능을 묶어서 제공
    - FrontController : 프론트 컨트롤러에서 자원에게 재요청 혹은 재응답을 하게되는데 최초에 web.xml에게 한 요청/응답과 동일하게 유지할 수 있도록 해줌
    - RequestDispatcher : FrontController에 도착한 요청/응답을 그대로 유지시켜줌