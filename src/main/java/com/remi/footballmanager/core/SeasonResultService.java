package com.remi.footballmanager.core;

import com.remi.footballmanager.core.competition.League;
import com.remi.footballmanager.core.competition.SeasonResult;
import com.remi.footballmanager.scrapper.SeasonResultScrapper;
import org.springframework.stereotype.Service;

@Service
public class SeasonResultService {
    private final SeasonResultScrapper seasonResultScrapper;

    public SeasonResultService(SeasonResultScrapper seasonResultScrapper) {
        this.seasonResultScrapper = seasonResultScrapper;
    }

    public SeasonResult getSeasonResult(League league, String season) {
        return seasonResultScrapper.extractSeasonResult(league, season);
    }

}
