package com.example.board; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController — 환경 확인용.
 *
 * URL: GET /
 * 하는 일: "Hello World" 문자열만 응답 (DB 안 씀)
 * 프로젝트 전체 URL 지도는 BoardApplication.java 참고.
 *
 * ========== 문법 ==========
 *
 * 1) @RestController
 *    - 클래스 위에 붙는 표시(어노테이션)
 *    - Spring에게 "웹 요청 처리 담당으로 등록해 줘" + "반환값을 JSON/문자열로 응답해 줘"
 *    - 내부적으로 @Controller + @ResponseBody 와 같음
 *    - 비교: @Controller + 뷰 이름이면 HTML,
 *            @RestController면 반환값을 HTTP body에 그대로 (문자열/JSON)
 *
 * 2) @GetMapping("/")
 *    - HTTP GET 이면서 경로가 / 일 때 아래 메서드를 호출
 *    - 예: http://localhost:8080/
 *
 * 3) public String hello() / return "Hello World"
 *    - 반환 문자열이 응답 body → 브라우저에 그대로 표시
 *    - (객체를 return 하면 Jackson이 JSON으로 바꿈 — BoardController의 /jsonBoards 참고)
 *
 * 누가 부르나?
 *  1) 기동 시 패키지 스캔으로 이 컨트롤러 등록
 *  2) GET / 요청 → DispatcherServlet이 @GetMapping("/")을 찾아 호출
 */

// @RestController: 이 클래스를 Spring MVC Controller로 등록 + 반환값을 그대로 HTTP 응답 body로 씀
@RestController
public class HelloController {

    // GET http://localhost:8080/ 요청이 오면 이 메서드가 호출됨
    // (@SpringBootApplication이 같은 패키지를 스캔해서 이 Controller를 자동 등록)
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}