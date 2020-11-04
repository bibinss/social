package com.video.social.dataaccess;

import com.video.social.entity.Team;

import java.util.List;

public interface TeamsRepository {
    public List<Team> getTeams(String coachName);
    public Team getTeam(String teamId);
    public void createTeam(String coachName, Team team);
}
