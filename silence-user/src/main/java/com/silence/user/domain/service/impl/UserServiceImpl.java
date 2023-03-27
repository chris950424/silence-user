package com.silence.user.domain.service.impl;

import com.silence.user.domain.entity.User;
import com.silence.user.domain.repository.UserRepository;
import com.silence.user.domain.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<String> findPermissionsByUserId(String id) {
        return userRepository.findPermissionsByUserId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addUser(User user) {
        int save = userRepository.save(user);
        return String.valueOf(save);
    }
}
