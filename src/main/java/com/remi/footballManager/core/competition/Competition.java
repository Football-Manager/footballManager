package com.remi.footballManager.core.competition;

import com.remi.footballManager.core.Player;
import com.remi.footballManager.core.Team;
import lombok.Builder;

import java.util.List;

@Builder
public class Competition {
    private String name;
    private String season;
    private Integer teamsNumber;
    List<Team> teams;
    Team champion;
    Player topScorer;

}
