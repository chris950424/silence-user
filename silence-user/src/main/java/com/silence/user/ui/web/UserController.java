package com.silence.user.ui.web;

import com.silence.api.UserDto;
import com.silence.user.application.UserApplicationService;
import com.silence.user.infrastructure.base.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 *  UserController
 * 
 * @author leo
 * @version 1.1.0
 * @date 2021/12/28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserApplicationService applicationService;

    @GetMapping("/getUserInfo")
    public ApiResponse<UserDto> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = ((UserDto) authentication.getPrincipal());
        return ApiResponse.success(userDto);
    }
    /**
     * 查询用户权限
     *
     * @param username
     * @return
     */
    @PostMapping(value = "/getUserByUserName")
    public UserDto getUserByUserName(@RequestParam("username") String username) {
        return applicationService.getUserByUserName(username);
    }

    /**
     * 查询用户权限
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/findPermissionsByUserId")
    public List<String> findPermissionsByUserId(@RequestParam("id") String id) {
        return applicationService.findPermissionsByUserId(id);
    }

}
