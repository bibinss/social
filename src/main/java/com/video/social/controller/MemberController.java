package com.video.social.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/teams/{id}/members")
    public String getTeam(@RequestParam("id") String teamId, final Model model, Authentication authentication) {
        return "members";
    }
}
