package com.example.forfafa.domain.user.controller;

import com.example.forfafa.domain.user.dto.LoginRequestDto;
import com.example.forfafa.domain.user.dto.LoginResponseDto;
import com.example.forfafa.domain.user.dto.SignupRequestDto;
import com.example.forfafa.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDto request) {
        userService.signup(request);
        return ResponseEntity.ok("USER 회원가입 완료");
    }
    @PostMapping("/admin")
    public ResponseEntity<?> admin(@RequestBody SignupRequestDto request) {
        userService.signup(request);
        return ResponseEntity.ok("ADMIN 회원가입 완료");
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}