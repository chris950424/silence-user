package com.silence.user.domain.service;

import com.silence.user.domain.entity.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    List<String> findPermissionsByUserId(String id);

    String addUser(User user);
}
