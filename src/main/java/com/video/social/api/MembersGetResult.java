package com.video.social.api;

import lombok.Data;

import java.util.List;

@Data
public class MembersGetResult {
    private List<Member> members;
}
