package com.video.social.api;

import lombok.Data;

@Data
public class MemberRegisterForm {
    private String firstName;
    private String lastName;
    private String phone;
    private String parentPhone1;
    private String parentPhone2;
}
