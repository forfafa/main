package com.example.forfafa.domain.user.service;

import com.example.forfafa.domain.user.dto.LoginRequestDto;
import com.example.forfafa.domain.user.dto.LoginResponseDto;
import com.example.forfafa.domain.user.dto.SignupRequestDto;
import com.example.forfafa.domain.user.mapper.UserRepository;
import com.example.forfafa.domain.user.model.Role;
import com.example.forfafa.domain.user.model.User;
import com.example.forfafa.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public void signup(SignupRequestDto request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(null, request.getUsername(), encodedPassword, Role.USER);
        userRepository.insert(user);
    }
    @Override
    public void admin(SignupRequestDto request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(null, request.getUsername(), encodedPassword, Role.ADMIN);
        userRepository.insert(user);
    }
    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        String token = jwtProvider.generateToken(user);
        return new LoginResponseDto(token);
    }
}