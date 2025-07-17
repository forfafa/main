package com.example.forfafa.domain.user.mapper;

import com.example.forfafa.domain.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    User findByUsername(String username);
    void insert(User user);
}