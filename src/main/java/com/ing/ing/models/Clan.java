package com.ing.ing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clan implements Comparable<Clan> {
    private int numberOfPlayers;
    private int points;

    @JsonProperty("numberOfPlayers")
    public final void setNumberOfPlayers(int numberOfPlayers) {
        if(numberOfPlayers < 1 || numberOfPlayers > 1000) throw new IllegalArgumentException("Bad number of players");
        this.numberOfPlayers = numberOfPlayers;
    }
    @JsonProperty("points")
    public final void setPoints(int points) {
        if(points < 1 || points > 1000000) throw new IllegalArgumentException("Bad number of points");
        this.points = points;
    }

    public final int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public final int getPoints() {
        return points;
    }

    @Override
    public int compareTo(Clan o) {
        int regionComparison = -Integer.compare(this.points, o.points);
        if (regionComparison != 0) {
            return regionComparison;
        }

        return Integer.compare(this.numberOfPlayers, o.numberOfPlayers);
    }
}
