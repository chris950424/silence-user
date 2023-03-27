package com.silence.useradmin.ui.web;

import com.silence.useradmin.application.service.AuthorityApplicationService;
import com.silence.useradmin.infrastructure.base.ApiResponse;
import com.silence.api.UserDto;
import com.silence.useradmin.ui.entity.command.AddUserAdminCommand;
import com.silence.useradmin.ui.entity.command.UpdateUserAdminCommand;
import com.silence.useradmin.ui.entity.command.UserAdminAndRoleCommand;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClientController
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
@RestController()
@RequestMapping("/authority")
public class AuthorityController {


    @Resource
    AuthorityApplicationService applicationService;


    @PreAuthorize("hasAuthority('addUserAdmin')")
    @PostMapping("/userAdmin/addUserAdmin")
    public ApiResponse<String> addUserAdmin(@RequestBody AddUserAdminCommand auac) {
        return applicationService.addUserAdmin(auac);
    }


    @PreAuthorize("hasAuthority('updateUserAdmin')")
    @PostMapping("/userAdmin/updateUserAdmin")
    public ApiResponse<String> updateUserAdmin(@RequestBody UpdateUserAdminCommand uuac) {
        return applicationService.updateUserAdmin(uuac);
    }

    @PreAuthorize("hasAuthority('deleteUserAdmin')")
    @DeleteMapping("/userAdmin/deleteUserAdmin/{id}")
    public ApiResponse<String> deleteUserAdmin(@PathVariable("id") String id) {
        return applicationService.deleteUserAdmin(id);
    }

    @PreAuthorize("hasAuthority('setRoleForUserAdmin')")
    @PostMapping("/userAdmin/setRoleForUserAdmin")
    public ApiResponse<String> setRoleForUserAdmin(@RequestBody UserAdminAndRoleCommand uaarc) {
        return applicationService.setRoleForUserAdmin(uaarc);
    }


    @PreAuthorize("hasAuthority('getUserAdminInfo')")
    @GetMapping("/userAdmin/getUserAdminInfo")
    public ApiResponse<UserDto> getUserAdminInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = ((UserDto) authentication.getPrincipal());
        List<String> authorities = new ArrayList<>();
        authentication.getAuthorities().forEach(a -> {
            authorities.add(a.getAuthority());
        });
        userDto.setAuthorities(authorities);
        return ApiResponse.success(userDto);
    }
}
