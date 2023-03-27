package com.silence.auth.ui.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * BaseMainController
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/23
 */
@Controller
public class BaseMainController {

    @GetMapping("/auth/login")
    public String loginPage(Model model) {
        model.addAttribute("loginProcessUrl", "/auth/authorize");
        return "base-login";
    }
}