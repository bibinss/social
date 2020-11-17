package com.video.social.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class NotificationsGetResult {
    private List<String> notifications;
    private ResponseStatus responseStatus;
}
