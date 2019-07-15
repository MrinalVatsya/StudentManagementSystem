package com.mind.logic;

import java.util.List;

import com.mind.entity.User;
import com.mind.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
   // void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
