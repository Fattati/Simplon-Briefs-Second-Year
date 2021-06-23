package com.springboot.service;

import com.springboot.model.User;
import com.springboot.model.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
    User update(User user);
    void deleteById(Long userId);
}
