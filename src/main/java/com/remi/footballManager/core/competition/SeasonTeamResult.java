package com.remi.footballManager.core.competition;

import com.remi.footballManager.core.Player;
import com.remi.footballManager.core.Team;
import lombok.Builder;
import lombok.Getter;

@Builder
public class SeasonTeamResult {
    Team team;
    private Integer matchPlayed;
    private Integer win;
    private Integer lost;
    private Integer draw;
    private Integer goalFor;
    private Integer goalAgainst;
    private Integer goalDifference;
    private Integer points;
    private Player topTeamScorer;
    private Player goalKeeper;
}
