package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LockerApi {
    @GetMapping("/lockers")
    public ResponseEntity<GetLockersResult> getLockers() {
        return new ResponseEntity(new GetLockersResult(), HttpStatus.OK);
    }

    @PostMapping("/lockers")
    public ResponseEntity<Locker> createLocker(@RequestBody LockerForm lockerForm) {
        return new ResponseEntity(new Locker(), HttpStatus.OK);
    }
}
