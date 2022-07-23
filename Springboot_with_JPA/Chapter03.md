-   Chapter03

## 1. 스프링이란?(3)

7. 스프링은 Message Converter를 가지고 있다(기본값은 JSON)
8. 스프링은 BufferedReader와 BufferedWriter를 쉽게 사용 할 수 있다
9. 스프링은 계속 발전중이다

---

### Message Converter

-   다른 플랫폼 간의 중간언어로 JSON을 사용함 : MessageConverter = Jackson

| 자바 프로그램  |                | 파이썬 프로그램 |
| -------------- | -------------- | --------------- |
|                | JSON           |                 |
| -------------  | request(요청)  | ------------->> |
|                | JSON           |                 |
| <<------------ | response(응답) | --------------- |

### BufferedReader

-   InputStreamReader를 사용 할 경우 fixed size의 배열을 쓰기 때문에 문자열이 잘리거나 공간낭비가 생길 수 있게 됨
-   BufferedReader는 가변 길이의 문자를 받을 수 있음

```java
// Reader
request.getReader();
// Writer
print();
println();

@ResponseBody // BufferedWriter로 데이터 전송
@RequestBody // BufferedReader로 데이터를 받음
```
