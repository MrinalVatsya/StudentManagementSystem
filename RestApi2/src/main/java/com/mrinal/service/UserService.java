package com.mrinal.service;

import com.mrinal.model.User;
import com.mrinal.model.UserDto;

import java.util.List;

import org.springframework.stereotype.Service;


public interface UserService {

    User save(UserDto user);
    List<User> findAll();
//    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
