package com.silence.useradmin.domain.service.impl;

import com.silence.useradmin.domain.repository.UserAdminRepository;
import com.silence.useradmin.domain.service.UserAdminService;
import com.silence.useradmin.domain.entity.UserAdmin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {

    private static final Log log = LogFactory.getLog(UserAdminServiceImpl.class);


    @Resource
    private UserAdminRepository repository;


    @Override
    public String addUserAdmin(UserAdmin userAdmin) {
        int i = repository.save(userAdmin);
        return "SUCCESS";
    }

    @Override
    public String updateUserAdmin(UserAdmin userAdmin) {
        int i = repository.save(userAdmin);
        return "SUCCESS";
    }

    @Override
    public String deleteUserAdmin(Long id) {
        int i = repository.remove(id);
        return String.valueOf(i);
    }


    @Override
    public List<String> findPermissionsByUserAdminId(Long id) {
        log.info("用户id:" + id, null);
        return repository.findPermissionsByUserAdminId(id);
    }

    @Override
    public UserAdmin getUserAdminByUserAdminName(String username) {
        log.info("用户名:" + username, null);
        return repository.findUserAdminByUserAdminName(username);
    }

    @Override
    public List<UserAdmin> userAdminList() {
        return repository.find();

    }

    @Override
    public String deleteRoleForUserAdmin(UserAdmin userAdmin) {
        int i = repository.removeRoleForUserAdmin(userAdmin);
        return String.valueOf(i);

    }

    @Override
    public String addRoleForUserAdmin(UserAdmin userAdmin) {
        int i = repository.saveRoleForUserAdmin(userAdmin);
        return String.valueOf(i);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String setRoleForUserAdmin(UserAdmin userAdmin) {
        List<Long> oldRoleIds = repository.findRoleForUserAdmin(userAdmin.getId());
        List<Long> newRoleIds = userAdmin.getRoleIds();
        List<Long> changeRole = oldRoleIds.stream().filter(a -> !newRoleIds.contains(a)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(changeRole)) {
            userAdmin.setRoleIds(changeRole);
            deleteRoleForUserAdmin(userAdmin);
        }
        changeRole = newRoleIds.stream().filter(a -> !oldRoleIds.contains(a)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(changeRole)) {
            userAdmin.setRoleIds(changeRole);
            addRoleForUserAdmin(userAdmin);
        }
        return "SUCCESS";
    }
}
