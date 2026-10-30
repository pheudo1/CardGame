package com.bao.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bao.model.*;


@RestController     
public class HandController {

    private final GameService gameService;

    public HandController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/hand")
    public List<Card> getHand() {
        return gameService.getHand();
    }
    
    @PostMapping("/api/play")
    public PlayResult playCards(@RequestBody PlayRequest request) {
        System.out.println("Controller got: " + request.getCardIds());
        return gameService.playCards(request.getCardIds());

    }

}
