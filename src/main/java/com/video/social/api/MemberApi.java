package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberApi {

    @GetMapping("/teams/{teamId}/members/")
    public ResponseEntity<GetMembersResult> getMembers() {
        return new ResponseEntity(new GetMembersResult(), HttpStatus.OK);
    }

    @PostMapping("/teams/{teamId}/members/register")
    public ResponseEntity<Member> registerMember(@RequestBody MemberRegisterForm memberRegisterForm) {
        return new ResponseEntity(new Member(), HttpStatus.OK);
    }
}
