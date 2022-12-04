package com.remi.footballmanager.core.competition;

public enum League {
    Ligue1("Ligue-1", 13),
    PremierLeague("Premier-League", 9),
    LaLiga("La-Liga", 12),
    BundesLiga("BundesLiga", 20),
    SerieA("Serie-A", 11);

    private int id;
    private String name;

    League(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
