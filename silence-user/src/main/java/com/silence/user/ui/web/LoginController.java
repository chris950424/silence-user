package com.silence.user.ui.web;

import com.silence.user.application.UserApplicationService;
import com.silence.user.infrastructure.base.ApiResponse;
import com.silence.user.ui.entity.command.AddUserCommend;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 *  UserController
 * 
 * @author leo
 * @version 1.1.0
 * @date 2021/12/28
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    UserApplicationService applicationService;

    @GetMapping( value = "/register")
    public ApiResponse<String> register(AddUserCommend auc) {
        return applicationService.addUser(auc);
    }
}
