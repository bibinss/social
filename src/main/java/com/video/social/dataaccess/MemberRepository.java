package com.video.social.dataaccess;

import com.video.social.entity.Member;

import java.util.List;

public interface MemberRepository {
    public List<Member> getMembers(String teamId);
    public void addMember(String teamId, Member member);
}
