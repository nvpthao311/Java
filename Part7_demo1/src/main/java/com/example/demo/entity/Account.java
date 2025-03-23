package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String fullname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}

/*
@Entity: Đánh dấu đây là một bảng trong database.

@Table(name = "account"): Đặt tên bảng là account.

@Id @GeneratedValue(strategy = GenerationType.IDENTITY): id là khóa chính, tự động tăng.

@Column(unique = true, nullable = false): username phải duy nhất và không được null.

Lombok (@Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor) giúp giảm code getter, setter.

 */