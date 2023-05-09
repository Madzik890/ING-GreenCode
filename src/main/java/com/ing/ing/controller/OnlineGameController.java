package com.ing.ing.controller;

import com.ing.ing.models.Clan;
import com.ing.ing.models.Players;
import com.ing.ing.view.OnlineGameView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/onlinegame")
public final class OnlineGameController {
    private OnlineGameView gameView = new OnlineGameView();

    @PostMapping("/calculate")
    public List<List<Clan>> Calculate(@RequestBody Players players) {
        if (players.getClans().isEmpty()) throw new ArrayIndexOutOfBoundsException("Clans of players are empty");
        return gameView.Calculate(players);
    }
}
