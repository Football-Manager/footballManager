package com.remi.footballManager.core.competition;

import com.remi.footballManager.core.Player;
import com.remi.footballManager.core.Team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(Integer matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(Integer goalFor) {
        this.goalFor = goalFor;
    }

    public Integer getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(Integer goalAgainst) {
        this.goalAgainst = goalAgainst;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Player getTopTeamScorer() {
        return topTeamScorer;
    }

    public void setTopTeamScorer(Player topTeamScorer) {
        this.topTeamScorer = topTeamScorer;
    }

    public Player getGoalKeeper() {
        return goalKeeper;
    }

    public void setGoalKeeper(Player goalKeeper) {
        this.goalKeeper = goalKeeper;
    }
}