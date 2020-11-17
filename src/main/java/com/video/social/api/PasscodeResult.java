package com.video.social.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasscodeResult {
    private String code;
    private ResponseStatus responseStatus;
}
