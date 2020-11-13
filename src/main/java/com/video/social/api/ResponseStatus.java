package com.video.social.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStatus {
    private ResponseStatusCode statusCode;
    private String message;
}
