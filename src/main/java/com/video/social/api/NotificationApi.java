package com.video.social.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static com.video.social.api.ResponseStatusCode.SUCCESS;

@RestController
@RequestMapping("/api")
public class NotificationApi {

    @GetMapping("/notifications")
    public ResponseEntity getNotifications(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity(new NotificationsGetResult(Collections.emptyList(),
                new ResponseStatus(SUCCESS, "Successfully fetched Notifications")), HttpStatus.OK);
    }
}
