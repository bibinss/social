package com.video.social.controller;

import com.video.social.dataaccess.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/")
    public String home(final Model model, Authentication authentication, @AuthenticationPrincipal OAuth2User user) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }
//        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
//                new ReactiveDataDriverContextVariable(videoRepository.findAllAsynch(), 1);
        model.addAttribute("videos", videoRepository.findAll());
        model.addAttribute("user", user.getAttribute("given_name"));
        return "home";
    }
}
