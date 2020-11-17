package com.video.social.api;

import lombok.Data;

@Data
public class UpdateProfileForm {
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
}
