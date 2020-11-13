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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.video.social.api.ResponseStatusCode.SUCCESS;
import static com.video.social.api.ResponseStatusCode.USER_REGISTRATION_FAILED;

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
        try {
            return new ResponseEntity(new ResponseStatus(SUCCESS, "Registration Successful"), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(new ResponseStatus(USER_REGISTRATION_FAILED, e.getMessage()), HttpStatus.OK);
        }
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
    public ResponseEntity resetPassword(@RequestBody ResetPasswordForm resetPasswordForm) {
        //TODO
        return new ResponseEntity("Password Reset Successful", HttpStatus.OK);
    }

    @GetMapping("/user/checkusername")
    public ResponseEntity checkUserName(@RequestParam String username) {
        //TODO
        return new ResponseEntity(HttpStatus.OK);
    }
}
