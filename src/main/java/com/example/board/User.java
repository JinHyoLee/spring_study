package com.example.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                // Getter, Setter, toString, equals 등을 자동으로 생성해 줍니다.
@NoArgsConstructor   // 파라미터가 없는 '기본 생성자'를 자동으로 생성해 줍니다. (JPA/JDBC 매핑에 필수!)
@AllArgsConstructor  // 모든 필드(id, name, email)를 받는 생성자를 자동으로 생성해 줍니다.
public class User {
    private Long id;
    private String name;
    private String email;
}