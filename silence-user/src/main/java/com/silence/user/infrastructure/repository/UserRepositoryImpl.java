package com.silence.user.infrastructure.repository;

import com.silence.user.domain.entity.User;
import com.silence.user.domain.repository.UserRepository;
import com.silence.user.infrastructure.repository.DO.UserDO;
import com.silence.user.infrastructure.repository.converter.UserConverter;
import com.silence.user.infrastructure.util.uid.UidGenerator;
import com.silence.user.infrastructure.dao.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Resource
    UserMapper userMapper;

    @Resource
    UidGenerator generator;

    @Resource
    PasswordEncoder encoder;

    @Override
    public User getUserByUsername(String username) {
        UserDO userDO = userMapper.getUserByUsername(username);
        return UserConverter.INSTANCE.userDoToUser(userDO);
    }

    @Override
    public List<String> findPermissionsByUserId(String id) {
        return userMapper.findPermissionsByUserId(id);
    }

    @Override
    public User getUserAdminByUsername(String username) {
        UserDO userDO = userMapper.getUserAdminByUsername(username);
        return UserConverter.INSTANCE.userDoToUser(userDO);

    }

    @Override
    public int save(User user) {
        UserDO dO = UserConverter.INSTANCE.userToUserDO(user);
        long uid = generator.getUID();
        dO.setId(uid);
        dO.setPassword(encoder.encode(dO.getPassword()));
        return userMapper.addUser(dO);
    }
}
