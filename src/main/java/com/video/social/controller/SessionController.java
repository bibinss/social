package com.video.social.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
    @GetMapping("/user/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:home";
        }
        return "login2";
    }

    @GetMapping("/user/logout")
    public String logout(Authentication authentication) {
        authentication.setAuthenticated(false);
        return "redirect:/user/login";
    }
}
