package com.video.social.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignInResult {
    private String token;
    private ResponseStatus responseStatus;
}
