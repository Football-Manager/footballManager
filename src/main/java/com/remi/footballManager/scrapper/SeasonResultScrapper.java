package com.remi.footballManager.scrapper;

import com.remi.footballManager.core.Team;
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
            case "rank" -> {}
            case "games" -> seasonTeamResult.setMatchPlayed(getIntegerFromElement(element));
            case "team" -> {
                Team team = new Team();
                team.setName(getStringFromElement(element));
                seasonTeamResult.setTeam(team);
            }
            case "wins" -> seasonTeamResult.setWin(getIntegerFromElement(element));
            case "ties" -> seasonTeamResult.setDraw(getIntegerFromElement(element));
            case "losses" -> seasonTeamResult.setLost(getIntegerFromElement(element));
            case "goals_for" -> seasonTeamResult.setGoalFor(getIntegerFromElement(element));
            case "goals_against" -> seasonTeamResult.setGoalAgainst(getIntegerFromElement(element));
            case "goal_diff" -> seasonTeamResult.setGoalDifference(getIntegerFromElement(element));
            case "points" -> seasonTeamResult.setPoints(getIntegerFromElement(element));
            case "points_avg" -> {}
            case "xg_for" -> {}
            case "xg_against" -> {}
            case "xg_diff" -> {}
            case "xg_diff_per90" -> {}
            case "last_5" -> {}
            case "attendance_per_g" -> {}
            case "top_team_scorers" -> {
                System.out.println(element.childNode(0));
            }
            case "top_keeper" -> {}
            case "notes" -> {}
            default -> {
                System.out.println(element.attr("data-stat"));
            }
        }
    }

    private Integer getIntegerFromElement(Element element){
        return Integer.valueOf(element.childNode(0).toString());
    }

    private String getStringFromElement(Element element) {
        return element.childNode(0).toString();
    }
}
