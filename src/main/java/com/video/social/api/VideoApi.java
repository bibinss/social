package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoApi {

    @GetMapping("/api/teams/{teamId}/lockers/{lockerId}/videos")
    public ResponseEntity<GetVideosResult> getTeamVideos() {
        return new ResponseEntity<>(new GetVideosResult(), HttpStatus.OK);
    }

    @PostMapping("/api/teams/{teamId}/lockers/{lockerId}/videos")
    public ResponseEntity<Video> uploadTeamVideos(@RequestBody UploadVideoForm uploadVideoForm) {
        return new ResponseEntity(new Video(), HttpStatus.OK);
    }
}
