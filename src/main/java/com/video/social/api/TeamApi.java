package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamApi {

    @PostMapping("/api/teams")
    public ResponseEntity<Team> createTeam(@RequestBody TeamForm teamForm) {
        return new ResponseEntity(new Team(), HttpStatus.OK);
    }

    @GetMapping("/api/teams")
    public ResponseEntity<GetTeamsResult> getTeams() {
        return new ResponseEntity(new GetTeamsResult(), HttpStatus.OK);
    }
}
