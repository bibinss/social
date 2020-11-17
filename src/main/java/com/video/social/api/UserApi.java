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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.video.social.api.ResponseStatusCode.*;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @PostMapping("/user/updateprofile")
    public ResponseEntity<UpdateProfileResult> register(@RequestBody UpdateProfileForm updateProfileForm) {
        try {
            return new ResponseEntity(
                    new UpdateProfileResult(new ResponseStatus(SUCCESS, "Successfully Updated Profile")),
                    HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(
                    new UpdateProfileResult(new ResponseStatus(USER_REGISTRATION_FAILED, e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //@PostMapping("/user/login")
    @Deprecated
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

    @PostMapping("/user/generatepasscode")
    public ResponseEntity<PasscodeResult> generatePasscode(@RequestParam String phoneNumber) {
        try {
            //TODO
            PasscodeResult passcodeResult = new PasscodeResult("123",
                    new ResponseStatus(SUCCESS, "Successful sent SMS with passcode"));
            return new ResponseEntity(passcodeResult, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(new PasscodeResult(null,
                    new ResponseStatus(UNKNOWN_FAILURE, e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/signin")
    public ResponseEntity<SignInResult> signIn(@RequestBody SignInForm userLogin, Model model) {
        try {
            //TODO
            return new ResponseEntity(new SignInResult("JWT-TOKEN",
                    new ResponseStatus(SUCCESS, "Sign In Successful")), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(new SignInResult(null,
                    new ResponseStatus(UNKNOWN_FAILURE, e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/signout")
    public ResponseEntity<SignOutResult> signOut(@RequestBody SignInForm userLogin, Model model) {
        //TODO
        return new ResponseEntity(new SignOutResult(
                new ResponseStatus(SUCCESS, "Sign Out Successful")), HttpStatus.OK);
    }
}
