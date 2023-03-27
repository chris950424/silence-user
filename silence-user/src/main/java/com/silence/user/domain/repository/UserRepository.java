package com.silence.user.domain.repository;

import com.silence.user.domain.entity.User;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
public interface UserRepository {

    User getUserByUsername(String username);

    List<String> findPermissionsByUserId(String id);

    User getUserAdminByUsername(String username);

    int save(User user);
}
