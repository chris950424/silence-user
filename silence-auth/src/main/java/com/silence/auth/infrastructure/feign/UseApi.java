package com.silence.auth.infrastructure.feign;

import com.silence.api.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Administrator
 */
@FeignClient(name = "silence-user")
public interface UseApi {

    @PostMapping("/user/findPermissionsByUserId")
    List<String> findPermissionsByUserId(@RequestParam("id") String id);

    @PostMapping("/user/getUserByUserName")
    UserDto getUserByUserName(@RequestParam("username") String username);

    @PostMapping("/user/getUserByUserName")
    int addUser(UserDto userDto);
}
