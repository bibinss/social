package com.video.social.api;

import com.video.social.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

import static com.video.social.api.ResponseStatusCode.SUCCESS;

@RestController
@RequestMapping("/api")
public class FileApi {

    @Autowired
    private VideoService videoService;

    @GetMapping("/files?type=video&category=community")
    public ResponseEntity<FilesGetResult> getCommunityVideos(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity<>(new FilesGetResult(Collections.emptyList(),
                new ResponseStatus(SUCCESS, "Successfully fetched Community videos")), HttpStatus.OK);
    }

    @GetMapping("/files?type=video&category=coaches")
    public ResponseEntity<FilesGetResult> getCoachedVideos(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity<>(new FilesGetResult(Collections.emptyList(),
                new ResponseStatus(SUCCESS, "Successfully fetched Coaches videos")), HttpStatus.OK);
    }

    @GetMapping("/files?type=video&category=personal")
    public ResponseEntity<FilesGetResult> getMyVideos(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity<>(new FilesGetResult(Collections.emptyList(),
                new ResponseStatus(SUCCESS, "Successfully fetched My videos")), HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<FileUploadResult> uploadFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                        @RequestParam("file") MultipartFile file,
                                                        String title, String description) {
        return new ResponseEntity<>(
                new FileUploadResult(new ResponseStatus(SUCCESS, "Successfully uploaded file")), HttpStatus.OK);
    }

    @DeleteMapping("/files")
    public ResponseEntity<FileDeleteResult> deleteFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                        @RequestParam("fileId") String fileId) {
        return new ResponseEntity<>(
                new FileDeleteResult(new ResponseStatus(SUCCESS, "Successfully deleted file")), HttpStatus.OK);
    }

//    @GetMapping("/teams/{teamId}/lockers/{lockerId}/videos")
//    public ResponseEntity<GetVideosResult> getTeamVideos() {
//        return new ResponseEntity<>(new GetVideosResult(Collections.emptyList(),
//                new ResponseStatus(SUCCESS, "Successfully fetched Team videos")), HttpStatus.OK);
//    }
//
//    @PostMapping("/teams/{teamId}/lockers/{lockerId}/videos")
//    public ResponseEntity<Video> uploadTeamVideos(@RequestParam("file") MultipartFile file) {
//        System.out.println("Video uplaod " + file.getName());
//        videoService.upload(file);
//        return new ResponseEntity(new Video(), HttpStatus.OK);
//    }
}
