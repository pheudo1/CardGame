package com.bao.model;

import java.util.List;

public class Move {
    
    private List<Card> card;
    private Player player;

    public Move(Player player, List<Card> card) {
        this.player = player;
        this.card = card;
        
    }

    


    public List<Card> getCard() {
        return card;
    }

    public Player getPlayer() {
        return player;
    }
}
