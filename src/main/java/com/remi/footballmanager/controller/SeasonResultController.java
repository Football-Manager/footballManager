package com.remi.footballmanager.controller;


import com.remi.footballmanager.core.SeasonResultService;
import com.remi.footballmanager.core.competition.League;
import com.remi.footballmanager.core.competition.SeasonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SeasonResult" )
public class SeasonResultController {
    private final SeasonResultService seasonResultService;
    public SeasonResultController(SeasonResultService seasonResultService){
        this.seasonResultService = seasonResultService;
    }

    @GetMapping("/league/{league}/season/{season}")
    public ResponseEntity<?> get(@PathVariable League league, @PathVariable String season){
        SeasonResult seasonResult = seasonResultService.getSeasonResult(league, season);
        return ResponseEntity.ok().body(seasonResult);
    }
}
