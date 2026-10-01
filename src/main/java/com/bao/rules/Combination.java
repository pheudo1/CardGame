package com.bao.rules;

import java.util.List;

import com.bao.model.Card;
import com.bao.model.Rank;

public class Combination {
    private CombinationType type;
    private int length;
    private Rank rank;
    private List<Card> cards;

    public Combination (CombinationType type, int length, Rank rank, List<Card> cards) {
        this.type = type;
        this.length = length;
        this.rank = rank;
        this.cards = cards;
    }

    public CombinationType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public Rank getRank() {
        return rank;
    }

    public List<Card> getCards() {
        return cards;
    }
}
