package com.remi.footballManager.scrapper;

import com.remi.footballManager.core.competition.SeasonResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class SeasonResultScrapper {

    public SeasonResultScrapper() {}

    public SeasonResult extractSeasonResult(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Element element = document.select("tbody").first();
            return SeasonResult.builder().build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
