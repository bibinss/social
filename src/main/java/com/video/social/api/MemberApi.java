package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApi {

    @GetMapping("/api/teams/{teamId}/members/")
    public ResponseEntity<GetMembersResult> getMembers() {
        return new ResponseEntity(new GetMembersResult(), HttpStatus.OK);
    }

    @PostMapping("/api/teams/{teamId}/members/register")
    public ResponseEntity<Member> registerMember(@RequestBody MemberRegisterForm memberRegisterForm) {
        return new ResponseEntity(new Member(), HttpStatus.OK);
    }
}
