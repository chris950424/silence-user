package com.silence.user.application;

import com.silence.api.UserDto;
import com.silence.user.application.assemble.UserAssemble;
import com.silence.user.domain.entity.User;
import com.silence.user.domain.service.UserService;
import com.silence.user.infrastructure.base.ApiResponse;
import com.silence.user.ui.entity.command.AddUserCommend;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserApplicationService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/30
 */
@Service
public class UserApplicationService {
    @Resource
    private UserService userService;

    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    public List<String> findPermissionsByUserId(String id) {
        return userService.findPermissionsByUserId(id);
    }

    public ApiResponse<String> addUser(AddUserCommend auc) {
        return ApiResponse.success(userService.addUser(UserAssemble.INSTANCE.aucToUser(auc)));
    }

    public UserDto getUserByUserName(String username) {
        return  UserAssemble.INSTANCE.userToUserDto(userService.getUserByUsername(username));
    }
}
