package com.remi.footballManager.controller;


import com.remi.footballManager.core.competition.SeasonResult;
import com.remi.footballManager.scrapper.SeasonResultScrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SeasonResult" )
public class SeasonResultController {
    private final SeasonResultScrapper scrapper;
    public SeasonResultController(SeasonResultScrapper scrapper){
        this.scrapper = scrapper; 
    }

    @GetMapping
    public ResponseEntity<?> get(){
        SeasonResult seasonResult = scrapper.extractSeasonResult("https://fbref.com/en/comps/13/Ligue-1-Stats");
        return ResponseEntity.ok().body(seasonResult);
    }
}
