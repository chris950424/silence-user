package com.silence.api;


import java.util.List;

/**
 * UserService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/23
 */
public interface UserService {
    /**
     * @return
     */
    String getUserName();


    UserDto getUserByUsername(String username);

    List<String> findPermissionsByUserId(String id);

    int addUser(UserDto userDto);
}
