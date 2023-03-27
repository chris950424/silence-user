package com.silence.auth.infrastructure.feign;

import com.silence.api.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Administrator
 */
@FeignClient(name = "silence-admin-user")
public interface UserAdminApi {

    @PostMapping("/user/findPermissionsByUserAdminId")
    List<String> findPermissionsByUserAdminId(@RequestParam("id") String id);

    @PostMapping("/user/getUserAdminByUserAdminName")
    UserDto getUserAdminByUserAdminName(@RequestParam("username") String username);
}
