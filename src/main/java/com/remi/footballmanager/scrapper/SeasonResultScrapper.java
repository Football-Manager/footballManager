package com.remi.footballmanager.scrapper;

import com.remi.footballmanager.core.Team;
import com.remi.footballmanager.core.competition.League;
import com.remi.footballmanager.core.competition.SeasonResult;
import com.remi.footballmanager.core.competition.SeasonTeamResult;
import com.remi.footballmanager.scrapper.exception.UnexpectedScrappingException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;

import static com.remi.footballmanager.scrapper.ScrapperUtil.getIntegerFromElement;
import static com.remi.footballmanager.scrapper.ScrapperUtil.getStringFromElement;

@Repository
public class SeasonResultScrapper {
    private final static String SEASON_RESULT_BASE_URL = "https://fbref.com/en/comps/";

    public SeasonResultScrapper() {
    }

    private String getSeasonResultUri(League league, String season) {
        return SEASON_RESULT_BASE_URL + league.getId() + "/" + season + "/" + season + "-" + league.getName() + "-Stat";
    }

    private String getTableId(League league, String season) {
        return "results" + season + league.getId() + "1_overall";
    }

    public SeasonResult extractSeasonResult(League league, String season) {
        String url = getSeasonResultUri(league, season);
        try {
            Document document = Jsoup.connect(url).get();
            Element element = Optional.ofNullable(document.getElementById(getTableId(league, season)))
                    .orElseThrow(UnexpectedScrappingException::new);
            Elements childrenElements = element.getElementsByTag("tr");
            childrenElements.remove(0);
            SeasonResult result = new SeasonResult();
            result.setSeasonTeamResult(childrenElements.stream().map(this::extractSeasonTeamResult).toList());
            return result;
        } catch (IOException e) {
            throw new UnexpectedScrappingException(e.getMessage());
        }
    }

    private SeasonTeamResult extractSeasonTeamResult(Element seasonTeamResultElement) {
        SeasonTeamResult seasonTeamResult = new SeasonTeamResult();
        seasonTeamResultElement.children().forEach(element -> fullFillSeasonTeamResult(seasonTeamResult, element));
        return seasonTeamResult;
    }

    private void fullFillSeasonTeamResult(SeasonTeamResult seasonTeamResult, Element element) {
        switch (element.attr("data-stat")) {
            case "rank" -> {
            }
            case "games" -> seasonTeamResult.setMatchPlayed(getIntegerFromElement(element));
            case "team" -> {
                Team team = new Team();
                team.setName(getStringFromElement(element.children().get(1)));
                seasonTeamResult.setTeam(team);
            }
            case "wins" -> seasonTeamResult.setWin(getIntegerFromElement(element));
            case "ties" -> seasonTeamResult.setDraw(getIntegerFromElement(element));
            case "losses" -> seasonTeamResult.setLost(getIntegerFromElement(element));
            case "goals_for" -> seasonTeamResult.setGoalFor(getIntegerFromElement(element));
            case "goals_against" -> seasonTeamResult.setGoalAgainst(getIntegerFromElement(element));
            case "goal_diff" -> seasonTeamResult.setGoalDifference(getIntegerFromElement(element));
            case "points" -> seasonTeamResult.setPoints(getIntegerFromElement(element));
            case "points_avg" -> {
            }
            case "xg_for" -> {
            }
            case "xg_against" -> {
            }
            case "xg_diff" -> {
            }
            case "xg_diff_per90" -> {
            }
            case "last_5" -> {
            }
            case "attendance_per_g" -> {
            }
            case "top_team_scorers" -> {
                System.out.println(element.childNode(0));
            }
            case "top_keeper" -> {
            }
            case "notes" -> {
            }
            default -> {
                System.out.println(element.attr("data-stat"));
            }
        }
    }


}
