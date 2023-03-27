package com.silence.useradmin.domain.service;

import com.silence.useradmin.domain.entity.UserAdmin;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
public interface UserAdminService {


    String addUserAdmin(UserAdmin userAdmin);

    String updateUserAdmin(UserAdmin userAdmin);

    String deleteUserAdmin(Long id);

    List<String> findPermissionsByUserAdminId(Long id);

    UserAdmin getUserAdminByUserAdminName(String username);

    List<UserAdmin> userAdminList();

    String deleteRoleForUserAdmin(UserAdmin userAdmin);

    String addRoleForUserAdmin(UserAdmin userAdmin);

    @Transactional(rollbackFor = Exception.class)
    String setRoleForUserAdmin(UserAdmin userAdmin);
}
