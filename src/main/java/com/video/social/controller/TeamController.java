package com.video.social.controller;

import com.video.social.dataaccess.MemberRepository;
import com.video.social.dataaccess.TeamsRepository;
import com.video.social.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class TeamController {

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/teams")
    public String getAllTeams(final Model model, Authentication authentication) {
        String coachName = authentication.getName();
        List<Team> teams = teamsRepository.getTeams(coachName);
        model.addAttribute("teams", teams);
        model.addAttribute("user", authentication.getName());
        System.out.println("team size" + teams.size());
        return "teams2";
    }

    @PostMapping(value = "/teams")
    public String addOneTeam(@RequestParam String teamName, Authentication authentication) {
        System.out.println(teamName);
        String coachName = authentication.getName();
        teamsRepository.createTeam(coachName, new Team(UUID.randomUUID().toString(),
                teamName));
        return "redirect:/teams";
    }

    @GetMapping("/addteam")
    public String loadAddTeamPage(final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        return "addteam2";
    }

    @GetMapping("/teams/{id}")
    public String getTeam(@PathVariable("id") String teamId,
                          final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        String coachName = authentication.getName();
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        model.addAttribute("members", memberRepository.getMembers(teamId));
        return "team2";
    }
}
