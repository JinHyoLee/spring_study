package com.example.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication: 자동 설정 + com.example.board 패키지 컴포넌트 스캔
// (HelloController 같은 @RestController를 찾아서 등록)

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
				// Embedded Tomcat을 띄우고 Spring 컨텍스트를 시작
		SpringApplication.run(BoardApplication.class, args);
	}

}
