package com.example.board;

public class User {
    private Long id;
    private String name;
    private String email;

    // Getter, Setter, 생성자 (Lombok을 쓴다면 @Getter @Setter 어노테이션으로 대체 가능)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
}