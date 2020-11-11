package com.video.social.api;

import lombok.Data;

import java.util.List;

@Data
public class GetLockersResult {
    private List<Locker> lockers;
}
