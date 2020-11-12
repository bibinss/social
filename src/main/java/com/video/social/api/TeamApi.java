package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeamApi {

    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@RequestBody TeamForm teamForm) {
        return new ResponseEntity(new Team(), HttpStatus.OK);
    }

    @GetMapping("/teams")
    public ResponseEntity<GetTeamsResult> getTeams() {
        return new ResponseEntity(new GetTeamsResult(), HttpStatus.OK);
    }
}
