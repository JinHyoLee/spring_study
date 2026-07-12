package com.example.board; 

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private JdbcTemplate jdbcTemplate; // 스프링이 자동으로 주입해주는 JDBC 도구

    @GetMapping("/add-user")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        // 직접 SQL 쿼리문 작성
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        
        // 쿼리 실행
        jdbcTemplate.update(sql, name, email);
        
        return name + " 사용자가 MySQL에 성공적으로 저장되었습니다!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        // 1. 실행할 SQL 쿼리문
        String sql = "SELECT * FROM users";
        
        // 2. 쿼리를 실행하고 결과를 자바 User 객체 리스트로 변환 (Lombok의 Getter/Setter가 여기서 맹활약합니다)
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        
        // 3. 브라우저로 리스트 반환 (스프링이 알아서 JSON 배열 형태로 예쁘게 변환해 줍니다)
        return userList;
    }
}