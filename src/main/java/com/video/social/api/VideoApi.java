package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VideoApi {

    @GetMapping("/teams/{teamId}/lockers/{lockerId}/videos")
    public ResponseEntity<GetVideosResult> getTeamVideos() {
        return new ResponseEntity<>(new GetVideosResult(), HttpStatus.OK);
    }

    @PostMapping("/teams/{teamId}/lockers/{lockerId}/videos")
    public ResponseEntity<Video> uploadTeamVideos(@RequestBody UploadVideoForm uploadVideoForm) {
        return new ResponseEntity(new Video(), HttpStatus.OK);
    }
}
