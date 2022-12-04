package com.remi.footballmanager.core.competition;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class SeasonResult {
    private List<SeasonTeamResult> seasonTeamResult;

    public List<SeasonTeamResult> getSeasonTeamResult() {
        return seasonTeamResult;
    }

    public void setSeasonTeamResult(List<SeasonTeamResult> seasonTeamResult) {
        this.seasonTeamResult = seasonTeamResult;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
