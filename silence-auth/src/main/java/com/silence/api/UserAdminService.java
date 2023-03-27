package com.silence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * UserService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/23
 */
public interface UserAdminService {


    List<String> findPermissionsByUserAdminId(String id);

    UserDto getUserAdminByUserAdminName(String username);
}
