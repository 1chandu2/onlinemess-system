package com.chandu.onlinemess.service;

import com.chandu.onlinemess.dto.UserDTO;
import com.chandu.onlinemess.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   Optional<User> getByUsername(String username);

   User saveUserWithDefaultParams(User user);

   User createUser(UserDTO userDTO);

   User findByUserName(String userName);

   List<User> findAll();
}
