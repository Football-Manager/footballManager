package com.remi.footballManager.core.competition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class SeasonResult {
    private List<SeasonTeamResult> seasonTeamResult;
}
