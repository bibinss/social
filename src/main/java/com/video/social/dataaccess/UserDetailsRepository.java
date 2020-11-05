package com.video.social.dataaccess;

import com.video.social.entity.Member;
import com.video.social.entity.Team;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDetailsRepository implements UserDetailsService, MemberRepository {
    static Map<String, List<Member>> membersMap = new HashMap<>();
    static  {
        List<Member> members = new ArrayList<>();
        members.add(new Member(UUID.randomUUID().toString(), "Coach", "coach@gmail.com", "ROLE_COACH"));
        membersMap.put("coach", members);
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("user name " + userName);
        for (List<Member> members : membersMap.values()) {
            for (Member member : members) {
                if (member.getEmail().equals(userName)) {
                    return member;
                }
            }
        };
        System.out.println();
        return null;
    }

    @Override
    public Member getMember(String memberId) {
        for (List<Member> members : membersMap.values()) {
            for (Member m : members) {
                if (m.getId().equals(memberId)) {
                    return m;
                }
            }
        }
        return null;
    }

    @Override
    public List<Member> getMembers(String teamId) {
        return membersMap.getOrDefault(teamId, new ArrayList<>());
    }

    @Override
    public void addMember(String teamId, Member member) {
        List<Member> members = membersMap.getOrDefault(teamId, new ArrayList<>());
        members.add(member);
        membersMap.put(teamId, members);
    }

    @Override
    public String getTeamId(String memberId) {
        for (Map.Entry<String, List<Member>> kv : membersMap.entrySet()) {
            for (Member member : kv.getValue()) {
                if (member.getId().equals(memberId)) {
                    return kv.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public Member getMemberByEmail(String email) {
        for (Map.Entry<String, List<Member>> kv : membersMap.entrySet()) {
            for (Member member : kv.getValue()) {
                if (member.getEmail().equals(email)) {
                    return member;
                }
            }
        }
        return null;
    }

}
