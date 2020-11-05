package com.video.social.dataaccess;

import com.video.social.entity.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TeamsRepositoryImpl implements TeamsRepository {

    Map<String, List<Team>> teamsMap = new HashMap<>();

    @Override
    public List<Team> getTeams(String coachName) {
        return teamsMap.getOrDefault(coachName, new ArrayList<>());
    }

    @Override
    public Team getTeam(String teamId) {
        for (List<Team> teams : teamsMap.values()) {
            for (Team t : teams) {
                if (t.getId().equals(teamId)) {
                    return t;
                }
            }
        }
        return null;
    }

    @Override
    public void createTeam(String coachName, Team team) {
        List<Team> teams = teamsMap.getOrDefault(coachName, new ArrayList<>());
        teams.add(team);
        teamsMap.put(coachName, teams);
    }
}
