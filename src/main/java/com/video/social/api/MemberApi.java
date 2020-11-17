package com.video.social.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberApi {

    @GetMapping("/classes/{classId}/members")
    public ResponseEntity<MembersGetResult> getMembers() {
        return new ResponseEntity(new MembersGetResult(), HttpStatus.OK);
    }

    @PostMapping("/classes/{classIdId}/members")
    public ResponseEntity<Member> registerMember(@RequestBody MemberRegisterForm memberRegisterForm) {
        return new ResponseEntity(new Member(), HttpStatus.OK);
    }
}
