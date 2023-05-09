package com.ing.ing.view;

import com.ing.ing.models.Clan;
import com.ing.ing.models.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class OnlineGameView {
    public List<List<Clan>> Calculate(Players players){
        var clans = players.getClans();
        var numberOfPlayers = players.getNumberOfPlayers();
        var result = new ArrayList<List<Clan>>();
        var playerInGroup = 0;

        Collections.sort(clans);

        while (!clans.isEmpty()) {
            var singleGroup = new ArrayList<Clan>();
            var iterator = clans.iterator();

            while(iterator.hasNext()) {
                var clan = iterator.next();

                if(playerInGroup + clan.getNumberOfPlayers() > numberOfPlayers) { continue; }

                playerInGroup += clan.getNumberOfPlayers();
                singleGroup.add(clan);
                iterator.remove();

                if(playerInGroup == numberOfPlayers) { break; }
            }

            result.add(singleGroup);
            playerInGroup = 0;
        }

        return result;
    }
}
