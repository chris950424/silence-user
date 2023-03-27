package com.silence.user.infrastructure.dao;

import com.silence.user.infrastructure.repository.DO.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
  
    
    UserDO getUserByUsername(String username);

    List<String> findPermissionsByUserId(String id);

    UserDO getUserAdminByUsername(String username);

    int addUser(UserDO userDO);

    int addRoleForUser(Long uid);
}
