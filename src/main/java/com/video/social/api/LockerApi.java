package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockerApi {
    @GetMapping("/api/lockers")
    public ResponseEntity<GetLockersResult> getLockers() {
        return new ResponseEntity(new GetLockersResult(), HttpStatus.OK);
    }

    @PostMapping("/api/lockers")
    public ResponseEntity<Locker> createLocker(@RequestBody LockerForm lockerForm) {
        return new ResponseEntity(new Locker(), HttpStatus.OK);
    }
}
