package com.ing.ing.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class Players {
    @JsonIgnore
    private int numberOfPlayers;
    private List<Clan> clans;

    @JsonProperty("groupCount")
    public void setNumberOfPlayers(int numberOfPlayers) {
        if(numberOfPlayers < 1 || numberOfPlayers > 1000) throw new IllegalArgumentException("Bad number of players");
        this.numberOfPlayers = numberOfPlayers;
    }
    @JsonProperty("clans")
    public void setClans(List<Clan> clans) {
        if(clans.size() > 20000) throw new IllegalArgumentException("Number of clans is higher than 20000");
        this.clans = clans;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public List<Clan> getClans() {
        return clans;
    }
}
