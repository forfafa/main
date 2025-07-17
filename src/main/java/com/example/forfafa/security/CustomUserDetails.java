package com.example.forfafa.security;

import com.example.forfafa.domain.user.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    //권한 부여. ROLE_USER, ROLE_ADMIN 같은 형식으로 지정
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // "ROLE_USER" 또는 "ROLE_ADMIN" 형식으로 반환
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }
    //Spring Security 로그인 시 사용하는 비밀번호
    @Override public String getPassword() { return user.getPassword(); }
    //로그인 시 사용하는 아이디 (username)
    @Override public String getUsername() { return user.getUsername(); }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}