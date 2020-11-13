package com.video.social.api;

import lombok.Data;

@Data
public class RegisterUserForm {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;
}
