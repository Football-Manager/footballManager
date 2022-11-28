package com.remi.footballManager.core;

import lombok.Builder;

import java.util.List;

@Builder
public class Team {
    private String name;
    private List<Player> players;
    private Coach coach;
}
