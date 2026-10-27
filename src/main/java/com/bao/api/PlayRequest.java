package com.bao.api;

import java.util.List;

public class PlayRequest {

    private List<Integer> cardIds;

    public List<Integer> getCardIds() {
        return cardIds;
    }

    public void setCardIds(List<Integer> cardIds) {
        this.cardIds = cardIds;
    }
}