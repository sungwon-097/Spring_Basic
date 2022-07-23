-   Chapter11

## 3. Spring Boot 동작 원리(4)

3. web.xml

---

### web.xml

-   Servlet Context의 초기 parameter 설정  
    : 문지기와 같은 개념
-   Session의 유효시간 설정  
    : 접근 가능한 시간, 초기화하여 유효시간 이상 사용 가능
-   Servlet/JSP에 대한 정의, Mapping  
    : 접근하려는 자원이 존재하는 위치가 정의돼있고 매핑함
-   Mine Type Mapping  
    : 들고 올 데이터의 타입을 확인하고 어디로 가야 할지 매핑( ex) GET)
-   Welcome File List  
    : 데이터를 가지고 오지 않은 요청에 대한 응답
-   Error Pages 처리  
    : Error를 어떤 페이지로 handling 할지
-   Listener / Filter 설정  
    : 특정 이벤트가 발생하기까지 대기하다 실행되는 behavior가 Listener, 요청에 대한 인증, 권한 체크 등을 하는 데에 Filter 사용
-   Security
    : 인증, 권한, 인가 등을 담당
