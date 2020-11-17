package com.video.social.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class MessagesResult {
    private List<String> messages;
    private ResponseStatus responseStatus;
}
