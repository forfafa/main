package com.example.forfafa.domain.user.model;

import lombok.Getter;

@Getter
public class User {
    private final Long id;
    private final String username;
    private final String password;
    private Role role;

    public User(Long id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
