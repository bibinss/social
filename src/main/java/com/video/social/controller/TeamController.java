package com.video.social.controller;

import com.video.social.dataaccess.MemberRepository;
import com.video.social.dataaccess.TeamsRepository;
import com.video.social.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "teams2";
    }

    @PostMapping(value = "/teams")
    public String addTeam(@RequestParam String teamName, Authentication authentication) {
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
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        return "team2";
    }

    @GetMapping("/teams/{id}/videos")
    public String getVideos(@PathVariable("id") String teamId,
                            final Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("team", teamsRepository.getTeam(teamId));
        return "team-videos";
    }
}
