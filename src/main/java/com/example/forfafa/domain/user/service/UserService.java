package com.example.forfafa.domain.user.service;

import com.example.forfafa.domain.user.dto.LoginRequestDto;
import com.example.forfafa.domain.user.dto.LoginResponseDto;
import com.example.forfafa.domain.user.dto.SignupRequestDto;

public interface UserService {
    void signup(SignupRequestDto request);
    void admin(SignupRequestDto request);
    LoginResponseDto login(LoginRequestDto request);
}
