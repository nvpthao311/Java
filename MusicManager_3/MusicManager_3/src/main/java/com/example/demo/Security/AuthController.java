package com.example.demo.Security;

import com.example.demo.Security.Jwt.JwtResponse;
import com.example.demo.Security.Jwt.JwtUtil;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.Jwt.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authManager;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);

        return  ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Login: " + loginRequest.getUsername() + ", " + loginRequest.getPassword());


        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication.getName());

        return ResponseEntity.ok(new JwtResponse(token));
    }

}
