package com.video.social.api;

import lombok.Data;

@Data
public class UserLogin {
    private String username;
    private String password;
    private String confirmPassword;
}
