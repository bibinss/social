package com.video.social.api;

import com.video.social.dataaccess.UserDetailsRepository;
import com.video.social.filter.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @PostMapping("/user/register")
    public ResponseEntity register(@RequestBody RegisterUserForm registerUser) {
        //TODO
        return new ResponseEntity("Registration Successful", HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserLoginForm userLogin) {
        try {
            String username = userLogin.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userLogin.getPassword()));
                        String token = jwtTokenProvider.createToken(username, new ArrayList<>());
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return new ResponseEntity(model, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
    @PostMapping("/user/resetpassword")
    public ResponseEntity resetPassword(@RequestBody UserLoginForm userLogin) {
        //TODO
        return new ResponseEntity("Password Reset Successful", HttpStatus.OK);
    }
}
