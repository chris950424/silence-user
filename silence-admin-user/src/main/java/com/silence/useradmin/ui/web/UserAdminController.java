package com.silence.useradmin.ui.web;

import com.silence.api.UserDto;
import com.silence.useradmin.application.service.AuthorityApplicationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserAdminController {

    @Resource
    AuthorityApplicationService applicationService;

    /**
     * 查询用户权限
     *
     * @param username
     * @return
     */
    @PostMapping(value = "/getUserAdminByUserAdminName")
    public UserDto getUserAdminByUserAdminName(@RequestParam("username") String username) {
        return applicationService.getUserAdminByUserAdminName(username);
    }

    /**
     * 查询用户权限
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/findPermissionsByUserAdminId")
    public List<String> findPermissionsByUserAdminId(@RequestParam("id") String id) {
        return applicationService.findPermissionsByUserAdminId(id);
    }
}
