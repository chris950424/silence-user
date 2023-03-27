package com.silence.useradmin.application.service;


import com.silence.useradmin.application.assemble.UserAdminAssemble;

import com.silence.useradmin.domain.entity.UserAdmin;
import com.silence.useradmin.domain.service.UserAdminService;
import com.silence.useradmin.infrastructure.base.ApiResponse;
import com.silence.api.UserDto;
import com.silence.useradmin.ui.entity.command.AddUserAdminCommand;
import com.silence.useradmin.ui.entity.command.UpdateUserAdminCommand;
import com.silence.useradmin.ui.entity.command.UserAdminAndRoleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * authorityApplicationServcie
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/29
 */
@Service
public class AuthorityApplicationService {
    Logger log = LoggerFactory.getLogger(AuthorityApplicationService.class);

    @Resource
    UserAdminService userAdminService;


    public ApiResponse<String> addUserAdmin(AddUserAdminCommand uac) {
        return ApiResponse.success(userAdminService.addUserAdmin(UserAdminAssemble.INSTANCE.auacToUserAdmin(uac)));

    }

    public ApiResponse<String> updateUserAdmin(UpdateUserAdminCommand uuac) {

        return ApiResponse.success(userAdminService.updateUserAdmin(UserAdminAssemble.INSTANCE.uuacToUserAdmin(uuac)));
    }

    public ApiResponse<String> deleteUserAdmin(String id) {
        return ApiResponse.success(userAdminService.deleteUserAdmin(Long.parseLong(id)));
    }


    public List<String> findPermissionsByUserAdminId(String id) {
        return userAdminService.findPermissionsByUserAdminId(Long.parseLong(id));
    }

    public UserDto getUserAdminByUserAdminName(String username) {
        UserAdmin userAdminByUserAdminName = userAdminService.getUserAdminByUserAdminName(username);
        return UserAdminAssemble.INSTANCE.userAdminToUserDto(userAdminByUserAdminName);
    }


    public ApiResponse<String> setRoleForUserAdmin(UserAdminAndRoleCommand uaarc) {
        return ApiResponse.success(userAdminService.setRoleForUserAdmin(UserAdminAssemble.INSTANCE.uaarcToUserAdmin(uaarc)));
    }
}
