package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @PostMapping("/api/user/register")
    public ResponseEntity register(@RequestBody RegisterUser registerUser) {
        //TODO
        return new ResponseEntity("Registration Successful", HttpStatus.OK);
    }

    @PostMapping("/api/user/login")
    public ResponseEntity login(@RequestBody UserLogin userLogin) {
        //TODO
        return new ResponseEntity("Login Successful", HttpStatus.OK);
    }
    @PostMapping("/api/user/resetpassword")
    public ResponseEntity resetPassword(@RequestBody UserLogin userLogin) {
        //TODO
        return new ResponseEntity("Password Reset Successful", HttpStatus.OK);
    }
}
