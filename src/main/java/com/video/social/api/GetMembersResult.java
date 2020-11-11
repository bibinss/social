package com.video.social.api;

import lombok.Data;

import java.util.List;

@Data
public class GetMembersResult {
    private List<Member> members;
}
