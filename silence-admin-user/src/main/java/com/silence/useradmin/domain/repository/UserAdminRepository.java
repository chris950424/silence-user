package com.silence.useradmin.domain.repository;

import com.silence.useradmin.domain.entity.UserAdmin;

import java.util.List;

/**
 * UserService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
public interface UserAdminRepository {

    int save(UserAdmin vo);

    int remove(Long id);

    List<String> findPermissionsByUserAdminId(Long id);

    UserAdmin findUserAdminByUserAdminName(String username);

    List<UserAdmin> find();

    int removeRoleForUserAdmin(UserAdmin admin);

    int saveRoleForUserAdmin(UserAdmin admin);

    List<Long> findRoleForUserAdmin(Long userId);
}
