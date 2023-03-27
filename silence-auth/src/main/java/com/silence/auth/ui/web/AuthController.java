package com.silence.auth.ui.web;

import com.silence.auth.application.service.AuthApplicationService;
import com.silence.auth.infrastructure.base.ApiResponse;
import com.silence.api.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AuthController
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/28
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

//    @Resource
//    private AuthApplicationService applicationService;
//
//    @PostMapping("/register")
//    private ApiResponse<String> register(UserDto dto) {
//        return applicationService.register(dto);
//    }

}
