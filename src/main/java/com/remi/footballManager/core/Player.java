package com.remi.footballManager.core;

import lombok.Builder;

@Builder
public class Player {
    private String firstName;
    private String lastName;
    private int height;
    private int weight;
    private Position position;
}
