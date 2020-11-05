package com.video.social.controller;

import com.video.social.dataaccess.MemberRepository;
import com.video.social.dataaccess.VideoRepository;
import com.video.social.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String home(final Model model, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }
//        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
//                new ReactiveDataDriverContextVariable(videoRepository.findAllAsynch(), 1);
        model.addAttribute("videos", videoRepository.findAll());
        model.addAttribute("user", authentication.getName());
        for (GrantedAuthority ga : authentication.getAuthorities()) {
            if (ga.getAuthority().equals("ROLE_STUDENT")) {
                Member member = memberRepository.getMemberByEmail(authentication.getName());
                String teamId = memberRepository.getTeamId(member.getId());
                return "redirect:/teams/" + teamId + "/members/" + member.getId();
            }
        }
        return "home2";
    }
}
