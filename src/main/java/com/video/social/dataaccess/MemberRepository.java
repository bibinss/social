package com.video.social.dataaccess;

import com.video.social.entity.Member;

import java.util.List;

public interface MemberRepository {
    public Member getMember(String memberId);
    public List<Member> getMembers(String teamId);
    public void addMember(String teamId, Member member);
    public String getTeamId(String memberId);
    public Member getMemberByEmail(String email);
}
