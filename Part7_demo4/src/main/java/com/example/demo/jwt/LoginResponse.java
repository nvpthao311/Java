package com.example.demo.jwt;

import java.util.List;

public class LoginResponse {
    private String jwtToken;
    private String username;
    private List<String> roles;

    public LoginResponse(String jwtToken,List<String> roles, String username ) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
    }


}
