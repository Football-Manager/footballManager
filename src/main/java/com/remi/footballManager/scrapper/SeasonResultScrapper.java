package com.remi.footballManager.scrapper;

import com.remi.footballManager.core.competition.SeasonResult;
import com.remi.footballManager.core.competition.SeasonTeamResult;
import com.remi.footballManager.scrapper.exception.UnexpectedScrappingException;
import io.swagger.models.auth.In;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SeasonResultScrapper {

    public SeasonResultScrapper() {}

    public SeasonResult extractSeasonResult(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Element element = Optional.ofNullable(document.getElementById("results2022-2023131_overall")).orElseThrow(UnexpectedScrappingException::new);

            Elements childrenElements = element.getElementsByTag("tr");
            childrenElements.remove(0);
            SeasonResult result = new SeasonResult();
            result.setSeasonTeamResult(childrenElements.stream().map(this::extractSeasonTeamResult).toList());
            return result;
        } catch (IOException e) {
            throw new UnexpectedScrappingException(e.getMessage());
        }
    }

    private SeasonTeamResult extractSeasonTeamResult(Element seasonTeamResultElement){
        SeasonTeamResult seasonTeamResult = new SeasonTeamResult();
        seasonTeamResultElement.children().forEach(element -> fullFillSeasonTeamResult(seasonTeamResult, element));
        return seasonTeamResult;
    }

    private void fullFillSeasonTeamResult(SeasonTeamResult seasonTeamResult, Element element){
        switch (element.attr("data-stat")) {
            case "games" -> seasonTeamResult.setMatchPlayed(getIntegerFromElement(element));
            default -> {}
        }
    }

    private Integer getIntegerFromElement(Element element){
        return Integer.valueOf(element.childNode(0).toString());
    }
}
