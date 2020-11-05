package com.video.social.controller;

import com.video.social.dataaccess.MemberRepository;
import com.video.social.dataaccess.TeamsRepository;
import com.video.social.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamsRepository teamsRepository;

    @GetMapping("/teams/{id}/members")
    public String getTeamMembers(@PathVariable("id") String teamId,
                                 final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        model.addAttribute("members", memberRepository.getMembers(teamId));
        return "members";
    }

    @GetMapping("/teams/{id}/addmember")
    public String loadAddTeamPage(@PathVariable("id") String teamId,
                                  final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        return "addmember";
    }

    @PostMapping("/teams/{id}/members")
    public String addTeamMember(@PathVariable("id") String teamId,
                                @RequestParam("email") String email,
                                @RequestParam("name") String name,
                                final Model model, Authentication authentication) {
        Member member = new Member(UUID.randomUUID().toString(), name, email, "ROLE_STUDENT");
        memberRepository.addMember(teamId, member);
        return "redirect:/teams/" + teamId + "/members";
    }

    @GetMapping("/teams/{teamid}/members/{memberid}")
    public String getTeamMember(@PathVariable("teamid") String teamId,
                                @PathVariable("memberid") String memberId,
                                 final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        model.addAttribute("member", memberRepository.getMember(memberId));
        return "member";
    }

    @GetMapping("/teams/{teamid}/members/{memberid}/videos")
    public String getMemberVideo(@PathVariable("teamid") String teamId,
                                @PathVariable("memberid") String memberId,
                                final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        model.addAttribute("member", memberRepository.getMember(memberId));
        return "member-videos";
    }

    @GetMapping("/teams/{teamid}/members/{memberid}/progress")
    public String getMemberProgress(@PathVariable("teamid") String teamId,
                                 @PathVariable("memberid") String memberId,
                                 final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        model.addAttribute("member", memberRepository.getMember(memberId));
        return "member-progress";
    }
}
